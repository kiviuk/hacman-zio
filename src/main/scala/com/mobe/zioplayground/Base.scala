package com.mobe.zioplayground

import com.mobe.zioplayground.Base.Car
import com.mobe.zioplayground.Core.OrdinaryCar
import com.mobe.zioplayground.Core.SportsCar

object Base:
  abstract class Car:

    println("Car")

    def model: String
    def topSpeedInKmPerHour: Int
    def topAccelerationInRpm: Int

    override def toString: String =
      val brand = getClass.getSimpleName
      ( if (brand == null) "" else brand ) + " " + model + " " + topSpeedInKmPerHour + " " + topAccelerationInRpm





