package com.mobe.zioplayground

object Modification:
  trait Spoiler extends Base.Car:

    abstract override def topSpeedInKmPerHour: Int =
      (super.topSpeedInKmPerHour * 1.02).toInt


