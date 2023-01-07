package com.mobe
package zioplayground

class CreditCardSuiteMUnit extends munit.FunSuite:

    case class Person(name: String, age:Age)
    case class Age(age: Int)

    val expected = List(Person("A", Age(10)), Person("B", Age(100)))

    val obtained = List(Person("A", Age(10)), Person("B", Age(100)))

    test("First test") {
        assertEquals(expected, obtained);
    }

    test("assertThrows example") {
        // Verify that an exception is thrown when we divide by zero
        interceptMessage[java.lang.ArithmeticException]("/ by zero"){
            1 / 0
        }
    }

    test("ignore mr".ignore){
      throw new RuntimeException()

    }

