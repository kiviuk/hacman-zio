package com.mobe
package zioplayground

import scala.annotation.targetName

final case class TwoDimensionalStr(
  top: String, middle: String, bottom: String):

  require(
    requirement = doAllRowsHaveSameLength()
    , message = "ALl rows must have the same length 3!"
  )

  private def doAllRowsHaveSameLength(): Boolean =
    top.length % 3 == 0
      && top.length == middle.length
      && middle.length == bottom.length

  @targetName("add")
  def +(that: TwoDimensionalStr): TwoDimensionalStr =
    TwoDimensionalStr(
      this.top + that.top,
      this.middle + that.middle,
      this.bottom + that.bottom)

  def show(): Unit =
    println(rendered)

  private def rendered: String =
    top + "\n" +
      middle + "\n" +
      bottom

object TwoDimensionalStr:

  val QuestionMarks: TwoDimensionalStr =
    TwoDimensionalStr(" ? ", " ? ", " ? ")

  val Empty: TwoDimensionalStr =
    TwoDimensionalStr("", "", "")
