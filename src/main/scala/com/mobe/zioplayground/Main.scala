package com.mobe
package zioplayground

import com.mobe.zioplayground.Write.*

import java.awt.Button
import java.util.EventListener

object Helpers:

  def showRed(string: String): Unit = styled(string, Console.RED)

  def showYellow(string: String): Unit = styled(string, Console.YELLOW)

  def showGreen(string: String): Unit = styled(string, Console.GREEN)

  private def styled(string: String, color: String): String =
    println(color + string + Console.RESET)
    ""


object Main:

  import Helpers.*
  import com.mobe.zioplayground.MyFile

  def main(args: Array[String]): Unit =
    println("-" * 30)
    code(args)
    println("-" * 30)

  def code(args: Array[String]): Unit =
    showRed("Red")
    showYellow("Yellow")
    showGreen("Green")

    val file = new MyFile(
      location = "/Users/m.benzid/Projects/zioplayground/src/main/scala/com/mobe/zioplayground",
      name = "Main",
      extension = "scala",
      content = "Blah")


    val diskUsage:Int = 10

    val newDiskUsage: Int =
      try
       file.write() match
         case Success(size) =>
           diskUsage + size
         case _ => diskUsage
      catch
        case Error(message) =>
          showRed(s"Warning: $message")
          diskUsage
        case Warning(message) =>
          showRed(s"Warning: $message")
          diskUsage
      end try


    println(s"diskUsage = $newDiskUsage bytes")

  end code
end Main

