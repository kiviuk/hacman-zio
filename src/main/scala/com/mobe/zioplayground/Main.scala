package com.mobe
package zioplayground

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Main:
  def main(args: Array[String]): Unit =
    println("-" * 30)
    code(args)
    println("-" * 30)


  def code(args: Array[String]): Unit =
    class Animal
    trait Pet:
      def allowedToSleepInBed: Boolean
      def disAllowedToSleepInBed: Boolean = ! allowedToSleepInBed
    class Cat extends Animal with Pet:
      val allowedToSleepInBed = true
    class Turtle extends Animal with Pet:
      val allowedToSleepInBed = false

    def show(pet: Pet): Unit =
      println(pet.disAllowedToSleepInBed)

//    show(new Cat)
//    show(new Turtle)

    trait Timestamp:
      val creationTime: String =
        lazy val formatter: DateTimeFormatter | Null = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")
        val now: LocalDateTime | Null = java.time.LocalDateTime.now()
        if (now == null || formatter == null) ""
        else
          val time = now.format(formatter)
          if (time == null) "" else time
    end Timestamp


    val path = "/Users/m.benzid/Projects/zioplayground/src/main/scala/com/mobe/zioplayground/Main.scala"
    val file: File & Timestamp = new File(path) with Timestamp

    def showName(file: File): Unit =
      println(s"file.getName = ${file.getName}")

    def showCreationTime(timestamp: Timestamp): Unit =
      println(s"file.creationTime = ${timestamp.creationTime}")

    showName(file)
    showCreationTime(file)

  end code
end Main

