package com.mobe.zioplayground

object Terminal:
  def clearTerminal: Unit = print("\u001b[2J")

  def goUp(linesToGoUp: Int): Unit = print(s"\u001b[${linesToGoUp}A")
