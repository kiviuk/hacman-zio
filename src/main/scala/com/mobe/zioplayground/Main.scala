package com.mobe
package zioplayground

import zio.*
import zio.Console.*

import java.io.IOException

object FarAway:

  def code = { name => name.isBlank }:(String => Boolean)

  def code2 = (name: String) => name.isBlank

@main def main(): Unit =

  def isMonday =
    println("isMonday")
    true

  def beHappy: String =
    if (isMonday && FarAway.code(""))
      "sad"
    else
      "happy"

  println(beHappy)




