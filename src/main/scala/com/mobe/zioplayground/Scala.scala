package com.mobe.zioplayground

import java.util.{Timer, TimerTask}
import scala.concurrent.duration.{DurationInt, FiniteDuration}

object Scala:

  def wait(interval: FiniteDuration):Unit = Thread.sleep(interval.toMillis)

  def loop(times: Int)(code: => Unit): Unit =
    1 to times foreach { _ => code }

  def tickUntilEnterIsPressed(interval: FiniteDuration)(code: => Unit): Unit =
    val timer: Timer = new Timer

    val delayInMilliSeconds:Long = 0L
    val periodInMilliseconds:Long = interval.toMillis
    val task: TimerTask = new TimerTask:
      override def run(): Unit = code

    timer.scheduleAtFixedRate(
      task,
      delayInMilliSeconds,
      periodInMilliseconds
    )

    io.StdIn.readLine()

    timer.cancel()

