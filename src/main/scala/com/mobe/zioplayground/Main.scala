package com.mobe
package zioplayground

import com.mobe.zioplayground.Constants.*
import com.mobe.zioplayground.TwoDimensionalStr

import scala.annotation.targetName
import scala.concurrent.duration.{DurationInt, FiniteDuration}

def showTime:Unit =
  Terminal.clearTerminal
  Terminal.goUp(LinesToGoUp)
  TwoDimensionalTime.showCurrent(TimePattern)

object TickUntilEnterIsPressed:

  def main(args: Array[String]): Unit =
    Scala.tickUntilEnterIsPressed(interval = Interval1Sec) {showTime}


object TickForFewSeconds:

  def main(args: Array[String]): Unit =
    Scala.loop(times = FewSeconds) {
      showTime
      Scala.wait(Interval1Sec)
    }

object Constants:

  val FewSeconds: Int = 3
  val TimePattern: String = "HH:mm:ss"
  val Interval1Sec: FiniteDuration = 1.second
  val LinesToGoUp: Int = Int.MaxValue
