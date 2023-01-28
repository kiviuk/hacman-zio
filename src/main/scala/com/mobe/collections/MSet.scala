package com.mobe.collections

import javax.print.attribute.standard.MediaSize.Other

trait MSet extends (String => Boolean):

  final def add(input: String): MSet = element => {

    input == element || this (element)
  }

  final def remove(input: String): MSet = element => {

//    element != input && this(element)

    if (element == input)
      false
    else
      this(element)
  }

  final def union(other: MSet): MSet = element => {
    this(element) || other(element)
  }

  final def intersect(other: MSet): MSet = element => {
    this (element) && other(element)
  }

  final def difference(other: MSet): MSet = element => {
    this(element) && !other(element)
  }

  final def isEmpty(): Boolean =  this == MSet.empty

object MSet:

  val empty: MSet = x => {
    println(s"EMPTY!!! $x")
    false

  }





 
