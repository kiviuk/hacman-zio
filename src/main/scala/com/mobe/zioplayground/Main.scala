package com.mobe
package zioplayground

import java.awt.Button
import java.util.EventListener





object Main:

  object File2:

    def apply(location: String, name: String, ext: String) = s"$location/$name.$ext"

    def unapply(path: String): Option[(String, String, String)] =

      val lastDotPos = path.lastIndexOf(".")
      val lastSlashPos = path.lastIndexOf("/")
      val ext = path.substring(lastDotPos + 1)
      val name = path.substring(lastSlashPos + 1, lastDotPos)
      val location = path.substring(0, lastSlashPos)

      if (path.isBlank || location == null || name == null || ext == null)
        None
      else
        Some((
          location,
          name,
          ext
        ))
    end unapply
  end File2


  case class File(location: String, name: String, ext: String)


  def main(args: Array[String]): Unit =
    println("-" * 30)
    code(args)
    println("-" * 30)

  def code(args: Array[String]): Unit =

    val explicitFile: String = "/Users/m.benzid/Projects/zioplayground/src/main/scala/com/mobe/zioplayground/Main.scala"

    val implicitFile: File =
      File(
        location = "/Users/m.benzid/Projects/zioplayground/src/main/scala/com/mobe/zioplayground",
        name = "Main",
        ext = "scala",
      )

    println("explicit: " + explicitFile)
    println("implicit: " + implicitFile)

    val x =File.apply
    val y = x("1", "2", "3")


  end code
end Main

