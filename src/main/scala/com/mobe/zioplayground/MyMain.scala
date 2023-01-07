package com.mobe.zioplayground

  sealed trait MyCreditCard:

    import MyCreditCard.*

    def number: String

    final def isValid(): Boolean = isInstanceOf[Valid]

    final def isNotValid(): Boolean = !isValid()


  object MyCreditCard:

    final case class Valid(number: String) extends MyCreditCard

    object Valid:

      def apply(number: String): Valid = new Valid(number)

    final case class Invalid(number: String) extends MyCreditCard

    object Invalid:

      def apply(number: String): Invalid = new Invalid(number)

    def apply(number: String): MyCreditCard =
      if (isValidNumber(number))
        Valid(number)
      else
        Invalid(number)

    def apply(): Valid =
      new Valid(generatedNumber)

    def generatedNumber = ""

    def isValidNumber(number: String): Boolean = true

