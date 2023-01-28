package com.mobe
package collection

import com.mobe.collections.*
import com.mobe.zioplayground.TestSuite

class MSetSuite extends TestSuite:

  test("apply on an empty set should yield false") {
    MSet.empty(randomString) shouldBe false
  }

  test("add on an empty set should yield a new Set with one element") {
    val first = randomString
    val second = randomString

    first should not be second

    val set: MSet = MSet.empty.add(first)

    set(first) shouldBe true
    set(second) shouldBe false
  }

  test("add on a non empty set should yield a new Set with two elements") {
    val first: String = "1"
    val second: String = "2"

    first should not be second

    val set1: MSet2 = MSet2.empty.add(first).add(second)

    set1(first) shouldBe true
    set1(second) shouldBe true

  }

  test("remove on a empty set should yield an empty Set") {

    val set1: MSet = MSet.empty.remove("1")

    set1("1") shouldBe false
    set1("99") shouldBe false

  }

  test("remove on an non empty set should yield a Set without the element") {
    val first: String = "1"
    val second: String = "2"

    first should not be second

    val set1: MSet = MSet.empty.add(first).add(second).remove(first).add(second)

    set1(first) shouldBe false
    set1("0") shouldBe false
    set1(second) shouldBe true
  }

  test("empty on an empty Set should yield true") {

    val set0: MSet = MSet.empty
    val set1: MSet = set0.add("1")
    val set2: MSet = set1.remove("1")

    set1.isEmpty() shouldBe (false)
    set2.isEmpty() shouldBe (false)


  }

  test("union on empty set should yield empty Set") {

    val set1: MSet = MSet.empty
    val set2: MSet = MSet.empty

    val set3 = set1.union(set2)

    set3("99") shouldBe false
  }

  test("union on a non empty set with a non empty Set should yield the original Set untouched") {

    val empty: MSet = MSet.empty
    val set2: MSet = MSet.empty.add("1")

    val set3 = empty.union(set2)
    val set4 = set2.union(empty)

    set3("1") shouldBe true
    set4("1") shouldBe true
  }

  test("union on two non empty Sets should yield their union") {

    val set1: MSet = MSet.empty.add("1")
    val set2: MSet = MSet.empty.add("2")

    val set3 = set1.union(set2)
    val set4 = set2.union(set1)

    set3("1") shouldBe true
    set3("2") shouldBe true

    set4("1") shouldBe true
    set4("2") shouldBe true

  }

  test("intersect on an empty Set should yield an empty Set") {

    val empty1: MSet = MSet.empty
    val empty2: MSet = MSet.empty

    val set3 = empty1.intersect(empty2)

    set3("1") shouldBe false
    set3("2") shouldBe false
  }

  test("intersect on a non empty Set with an empty Set should yield an empty Set") {

    val empty: MSet = MSet.empty
    val nonEmpty: MSet = MSet.empty.add("1")

    val set3 = empty.intersect(nonEmpty)
    val set4 = nonEmpty.intersect(empty)

    set3("1") shouldBe false
    set3("2") shouldBe false

    set4("2") shouldBe false
    set4("2") shouldBe false

  }

  test("intersect on two non empty Sets should yield their intersection") {

    val set1: MSet = MSet.empty.add("1")
    val set2: MSet = MSet.empty.add("2").add("1")

    val set3 = set1.intersect(set2)
    val set4 = set2.intersect(set1)

    set3("1") shouldBe true
    set3("2") shouldBe false

  }

  test("difference on an empty Set should yield an empty Set") {

    val set1: MSet = MSet.empty
    val set2: MSet = MSet.empty

    val set3 = set1.difference(set2)

    set3("1") shouldBe false
    set3("2") shouldBe false
  }

  test("difference on a non empty Set with an empty Set should yield the non empty Set untouched") {

    val empty: MSet = MSet.empty
    val nonEmpty: MSet = empty.add("1")

    val set3 = nonEmpty.difference(empty)

    set3("1") shouldBe true
  }

  test("difference on an empty Set with a non empty Set should yield an empty Set") {

    val empty: MSet = MSet.empty
    val nonEmpty: MSet = MSet.empty.add("1")

    val set3 = empty.difference(nonEmpty)

    set3("1") shouldBe false
  }

  test("difference on two non empty Sets should yield their difference") {

    val set1: MSet = MSet.empty.add("1").add("2")
    val set2: MSet = MSet.empty.add("2").add("0")

    val set3 = set1.difference(set2)
    val set4 = set2.difference(set1)

    set3("1") shouldBe true
    set4("1") shouldBe false

  }


  def randomString: String =
    scala.util.Random.alphanumeric.take(5).mkString

end MSetSuite


