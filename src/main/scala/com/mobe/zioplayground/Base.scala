package com.mobe.zioplayground

object Base:
  abstract class Car:
    def model: String
    def topSpeedInKmPerHour: Int
    def topAccelerationInRpm: Int

    override def toString: String =
      val brand = getClass.getSimpleName
      ( if (brand == null) "" else brand ) + " " + model + " " + topSpeedInKmPerHour + " " + topAccelerationInRpm


