package com.mobe
package zioplayground

import com.mobe.zioplayground.Constants.*
import com.mobe.zioplayground.TwoDimensionalStr

import scala.annotation.targetName
import scala.concurrent.duration.{DurationInt, FiniteDuration}



object TickForFewSeconds:

  def main(args: Array[String]): Unit =
    Scala.loop(times = FewSeconds) {
      Terminal.clearTerminal
      Terminal.goUp(LinesToGoUp)
      TwoDimensionalTime.showCurrent(TimePattern)
      Scala.wait(Interval)
    }

object Constants:

  val FewSeconds: Int = 30
  val TimePattern: String = "HH:mm:ss"
  val Interval: FiniteDuration = 1.second
  val LinesToGoUp: Int = Int.MaxValue
