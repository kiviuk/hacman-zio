package com.mobe.zioplayground

import com.mobe.zioplayground.Base.Car
import com.mobe.zioplayground.Core.OrdinaryCar

object Core:

  class OrdinaryCar(override val model: String) extends Base.Car:

    println("OrdinaryCar")

    override def topSpeedInKmPerHour: Int =
      println("OrdinaryCar.topSpeedInKmPerHour = 220")
      220

    override def topAccelerationInRpm: Int =
      println("OrdinaryCar.topAccelerationInRpm")
      8000
  end OrdinaryCar


  class SportsCar(override val model: String) extends Base.Car:

    println("SportsCar")

    override def topSpeedInKmPerHour: Int =
      println("SportsCar.topSpeedInKmPerHour = 300")
      300

    override def topAccelerationInRpm: Int = 11000
  end SportsCar

end Core

object Modification:

  trait Spoiler extends Car:

    println("Spoiler")

    abstract override def topSpeedInKmPerHour: Int =
      println("Spoiler.topSpeedInKmPerHour / 2")
      (super.topSpeedInKmPerHour / 2.0).toInt

  trait EngineControlUnit extends OrdinaryCar:

    println("EngineControlUnit")

    override def topSpeedInKmPerHour: Int =
      println("EngineControlUnit.topSpeedInKmPerHour + 3")
      (super.topSpeedInKmPerHour + 3.0).toInt

  trait TurboCharger extends OrdinaryCar:

    println("TurboCharger")

    override def topAccelerationInRpm: Int =
      println("TurboCharger.topAccelerationInRpm")
      (super.topAccelerationInRpm * 1.25).toInt

end Modification

final class Lambo(override val model: String)
  extends Core.SportsCar(model)
     with Modification.Spoiler {
}

final class BMW(override val model: String)

extends Core.OrdinaryCar(model)
    with Modification.Spoiler
    with Modification.EngineControlUnit
    with Modification.TurboCharger:
    println("Inheritance: BMW -> TurboCharger -> EngineControlUnit -> Spoiler -> OrdinaryCar -> Car -> AnyRef -> Any")
