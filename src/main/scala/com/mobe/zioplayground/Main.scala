package com.mobe
package zioplayground

import java.io.IOException

import zio.*
import zio.Console.*

@main def main(): Unit =

  //------------------------------------------
  case class Entity(id: Int, name: String)

  //------------------------------------------
  trait Api:

    def findById(id: Int): Unit

  trait OutputPort:

    def setResult(result: Option[Entity]): Unit

  trait ResourceApi:

    def getById(id: Int): Entity

  case class Core(outputPort: OutputPort, resource: ResourceApi) extends Api:

    override def findById(id: Int): Unit =

      val entity = resource.getById(id)

      val compute = Entity(entity.id, "new name!")
      outputPort.setResult(Some(compute))

  //------------------------------------------
  case class Database() extends ResourceApi:

    override def getById(id: Int): Entity =
      println(s"Db search id: $id")
      Entity(id, "some name")

  case class Console() extends OutputPort:

    override def setResult(result: Option[Entity]): Unit =
      println(s"Console: ${result.getOrElse("NaN")}")

  case class Controller(inputPort: Api):

    def doIt(id: Int): Unit = inputPort.findById(id)

  case class ResultCache() extends OutputPort:

    var computation: Option[Entity] = None

    override def setResult(result: Option[Entity]): Unit =
      computation = result


  val database = Database()
  val console = Console()
  val cache = ResultCache()

  Controller(Core(console, database)).doIt(1000)

  Controller(Core(cache, database)).doIt(1000)

  println(cache.computation.get.id)



