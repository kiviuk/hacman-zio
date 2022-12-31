package com.mobe.zioplayground
object TwoDimensionalDigit:
  val Zero: TwoDimensionalStr =
    TwoDimensionalStr( // format: off // format: off
      top    = " _ ",
      middle = "| |",
      bottom = "|_|"
    ) // format: on // format: on

  val One: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = "   ",
      middle = "  |",
      bottom = "  |"
    ) // format: on

  val Two: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = " _ ",
      middle = " _|",
      bottom = "|_ "
    ) // format: on

  val Three: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = " _ ",
      middle = " _|",
      bottom = " _|"
    ) // format: on

  val Four: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = "   ",
      middle = "|_|",
      bottom = "  |"
    ) // format: on

  val Five: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = " _ ",
      middle = "|_ ",
      bottom = " _|"
    ) // format: on

  val Six: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = " _ ",
      middle = "|_ ",
      bottom = "|_|"
    ) // format: on

  val Seven: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = " _ ",
      middle = "  |",
      bottom = "  |"
    ) // format: on

  val Eight: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = " _ ",
      middle = "|_|",
      bottom = "|_|"
    ) // format: on

  val Nine: TwoDimensionalStr =
    TwoDimensionalStr( // format: off
      top    = " _ ",
      middle = "|_|",
      bottom = " _|"
    ) // format: on

  def apply(digit: Int): TwoDimensionalStr = digit match
    case 0 => Zero
    case 1 => One
    case 2 => Two
    case 3 => Three
    case 4 => Four
    case 5 => Five
    case 6 => Six
    case 7 => Seven
    case 8 => Eight
    case 9 => Nine
    case _ => TwoDimensionalStr.QuestionMarks
