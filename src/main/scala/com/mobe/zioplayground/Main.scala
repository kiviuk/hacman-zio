package com.mobe
package zioplayground

import zio.*
import zio.Console.*

import java.io.IOException
import scala.annotation.tailrec

@main def main(): Unit =

  def X = println("-" * 60)

  X

  // def code = { name => name.isBlank }:(String => Boolean)


  def method =
    @tailrec
    def loop(iter: Int): String = if (iter % 5 !=0) loop(iter + 1) else "Done"
    loop(1)

//  println(method)

  def fac(n: Int): Int =
    var iter = n
    var acc = n
    while (iter > 2)
      iter -= 1
      acc *= iter

    acc

//  println(fac(1))


  def fib(n: Int): Int =
    if (n <= 1) n
    else fib(n - 1) + fib(n - 2)

  println(fib(50))


  X










