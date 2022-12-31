package com.mobe.zioplayground

import scala.concurrent.duration.{DurationInt, FiniteDuration}

object Scala:

  def wait(interval: FiniteDuration) = Thread.sleep(interval.toMillis)

  def loop(times: Int)(code: => Unit): Unit =
    1 to times foreach { _ => code }

