package com.mobe.zioplayground

import com.mobe.zioplayground.Write.Success
import com.mobe.zioplayground.Write.*

class MyFile(
  location: String,
  name: String,
  extension: String,
  content: String,
):
  def write(): Result =
    println(s"Writing $content to $location....")
    Thread.sleep(1000)
//    if (1==0) throw Error("No space left on device")
    Success(content.length)

object Write:
  sealed trait Result
  final case class Success(size: Int) extends Result
  final case class Warning(message: String) extends Exception with Result:

    override def toString: String = s"$productPrefix($message)"
  final case class Error(message: String) extends Exception with Result:
    override def toString: String = s"$productPrefix($message)"


