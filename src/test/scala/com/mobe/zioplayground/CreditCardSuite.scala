package com.mobe
package zioplayground

final class CreditCardSuite extends TestSuite:

  import com.mobe.zioplayground.Main.CreditCard
  import com.mobe.zioplayground.Main.CreditCard.*

  test("hello world") {
    forAll { (int: Int, string: String) =>
      expect(
        int === int,
        string === string,
      )
    }
  }

  test("Creating a credit card without passing any number should generate a valid credit card") {
    // arrange
    val cc = CreditCard()

    // act
    val res = cc.isValid

    // assert
    res shouldBe true
  }
  test("Creating a credit card without passing any number should generate a valid credit car of type valid") {
    // arrange
    val cc = CreditCard()

    // act

    // assert
    cc shouldBe a[CreditCard.Valid]

  }

  test("Creating a credit card manually by passing a valid number should generate a valid credit car of type valid") {
    // arrange
    val num = CreditCard().number

    // act
    val cc = CreditCard(num)

    // assert
    cc shouldBe a[CreditCard.Valid]

    noException should be thrownBy cc.asInstanceOf[CreditCard.Valid]


  }
