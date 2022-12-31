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
    println(new Lambo("Murcileago"))
    println(new BMW("M3 GTR"))
  end code
end Main

