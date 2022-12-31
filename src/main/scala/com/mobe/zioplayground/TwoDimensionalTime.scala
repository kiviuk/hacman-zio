package com.mobe.zioplayground

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TwoDimensionalTime:

  private val Stars = TwoDimensionalStr(
    top = "   ",
    middle = " * ",
    bottom = " * ",
  )

  def showCurrent(pattern: String): Unit =
    show(LocalDateTime.now, pattern)

  private def show(time: LocalDateTime | Null, pattern: String): Unit =
    if (time != null)
      formatted(time, pattern).show()

  private def formatted(time: LocalDateTime, pattern: String): TwoDimensionalStr =
    oneDimensional(time, pattern).foldLeft(TwoDimensionalStr.Empty) {
      (result, timeDigit) =>
        if (timeDigit == ':')
          result + Stars
        else
          result + TwoDimensionalDigit(timeDigit.toString.toInt)
    }

  private def oneDimensional(time: LocalDateTime, pattern: String): String =
    val formatter: DateTimeFormatter | Null = DateTimeFormatter.ofPattern(pattern)
    if (formatter != null)
      val res = time.format(formatter)
      if (res != null)
        res
      else
        ""
      else
      ""
