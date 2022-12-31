package com.mobe
package zioplayground

import scala.annotation.targetName
import com.mobe.zioplayground.TwoDimensionalStr

@main def main(): Unit =

  def X = println("-" * 60)

  X
  code()
  X

  def code(): Unit = TwoDimensionalTime.showCurrent(pattern = "HH:mm:ss")

end main


