package com.mobe.zioplayground

import com.mobe.zioplayground.Base.Car
import com.mobe.zioplayground.Core.OrdinaryCar

object Core:

  class OrdinaryCar(override val model: String) extends Base.Car:

    override def topSpeedInKmPerHour: Int = 220

    override def topAccelerationInRpm: Int = 8000
  end OrdinaryCar


  class SportsCar(override val model: String) extends Base.Car:

    override def topSpeedInKmPerHour: Int = 300

    override def topAccelerationInRpm: Int = 11000
  end SportsCar

end Core

object Modification:

  trait Spoiler extends Car:

    abstract override def topSpeedInKmPerHour: Int =
      (super.topSpeedInKmPerHour * 1.02).toInt

  trait EngineControlUnit extends OrdinaryCar:

    override def topSpeedInKmPerHour: Int =
      (super.topSpeedInKmPerHour * 1.5).toInt

  trait TurboCharger extends OrdinaryCar:

    override def topAccelerationInRpm: Int =
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
    with Modification.TurboCharger {
}
