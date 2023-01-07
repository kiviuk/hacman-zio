package com.mobe
package zioplayground

object Main:

  sealed trait CreditCard:

    import CreditCard.*

    def number: String

    final def isValid: Boolean = isInstanceOf[Valid]

    final def isNotValid: Boolean = !isValid

    final override def toString(): String =
      if (isNotValid)
        val invalid = Console.RED + "Invalid" + Console.RESET
        s"""$invalid credit card number "$number""""
      else
        val valid = Console.GREEN + "Valid" + Console.RESET
        val (payload, checkDigit) = split(number)
        s"""$valid credit card number "$number" with payload "$payload" and checkDigit "$checkDigit""""

  end CreditCard

  object CreditCard extends (String => CreditCard) with (() => CreditCard):

    private val CheckDigitLength: Int = 1
    private val MinimumLength = 13
    private val MaximumLength = 19

    final case class Valid private(number: String) extends CreditCard

    object Valid:

      def apply(number: String): Valid = new Valid(number)

    final case class Invalid private(number: String) extends CreditCard

    object Invalid:

      def apply(number: String): Invalid = new Invalid(number)

    def apply(number: String): CreditCard =
      if (isValid(number))
        Valid(number)
      else
        Invalid(number)

    def apply(): Valid = Valid(generatedNumber)

    private def generatedNumber: String =

      val payload:String =

        import scala.util.Random

        val min: Int = MinimumLength - CheckDigitLength
        val max: Int = MaximumLength - CheckDigitLength
        val length: Int = min + Random.nextInt( (max - min) + 1)

        def randomDigit: Int = Random.nextInt(10)

        def randomNUmber: String = (1 to length).map{ _ => randomDigit }.mkString

        randomNUmber
      end payload

      val checkDigit: Int =
        (10 - (luhn(payload) % 10)) % 10

      val number = payload + checkDigit

      if (isValid(number))
        number
      else
        sys.error(s"Bug: generated payload is invalid $number")

    end generatedNumber

    def luhn(payload: String): Int =
      payload.
        reverse.
        map(_.toString.toInt).
        zipWithIndex.
        map { case (digit, index) => if (index % 2 == 0) digit * 2 else digit }.
        map{ n => if (n > 9) n - 9 else n }.
        sum

    private def doesMathCheckOut(number: String): Boolean =
      val (payload, checkDigit) = split(number)
      val sum = luhn(payload) + checkDigit
      sum % 10 == 0

    private def isValid(number: String): Boolean =
        number.nonEmpty
        && number.forall(Character.isDigit)
        && (MinimumLength to MaximumLength).contains(number.length)
        && doesMathCheckOut(number)

    private def split(number: String): (String, Int) =
      val payload = number.dropRight(CheckDigitLength)
      val checkDigit = number.takeRight(CheckDigitLength)
      payload -> checkDigit.toInt

  end CreditCard


  def main(args: Array[String]): Unit =
    println("-" * 60)
    code(args)
    println("-" * 60)
  end main

  private def code(args: Array[String]): Unit =
    import CreditCard.*
    args
      .headOption
      .map(CreditCard)
      .map(println)
      .getOrElse(runDemo)

  private def runDemo: Unit =
    val validCard = CreditCard()
    println(validCard)

    val fakeNumbers = 1 to 10000 map(_ => CreditCard() )

    println(fakeNumbers.forall(_.isValid))

end Main
