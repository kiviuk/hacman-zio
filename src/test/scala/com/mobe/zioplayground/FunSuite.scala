package com.mobe
package zioplayground

final class FunSuite extends TestSuite:


  ignore("hello world") {
    forAll { (int: Int, string: String) =>
      expect(
        int === int,
        string === string,
      )
    }
  }
