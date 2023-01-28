package com.mobe.collections

sealed trait MSet2 extends (String => Boolean):
  private val self: MSet2 = this

  final def contains(element: String): Boolean =
    self.apply(element)

  /** Creates a new Set by adding an element to this one. */
  final def add(input: String): MSet2 =
    MSet2.instance { element =>
      // Either the element is this current input,
      // or this set contains it.
      element == input || self.contains(element)
    }

object MSet2:
  /** Creates a Set from a predicate. */
  def instance(p: String => Boolean): MSet2 =
    new MSet2:
      // Performs the contains check.
      override final def apply(element: String): Boolean =
        p(element)

  final val empty: MSet2 = instance(_ => false)
