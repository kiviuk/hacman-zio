package com.mobe
package zioplayground

final class ExampleSuite extends TestSuite:
  test("hello world") {
    forAll { (int: Int, string: String) =>
      expect(
        int === int,
        string === string,
      )
    }
  }
