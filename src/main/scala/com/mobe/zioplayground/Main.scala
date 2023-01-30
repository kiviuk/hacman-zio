package com.mobe
package zioplayground

object Main:



  def main(args: Array[String]): Unit =
    println("-" * 60)
    code(args)
    println("-" * 60)
  end main

  private def code(args: Array[String]): Unit =

    def cps[X, ContRes](input: X)(cont: X => ContRes ): ContRes = cont(input)

    {
      val f: Int = cps(5)(identity[Int])
//      println(f)
    }

      val f = cps("7") { n =>
        cps("5" + n) { n =>
          cps("1" + n) { n =>
            cps("0" + n) { n =>
              identity(n)
            }
          }
        }
      }

    println(f)

    val numbers = List(1, 2, 3, 4, 5)

    // for comprehension with yield
    val doubledNumbers = for {
      number <- numbers
    } yield number * 2
    // doubledNumbers will be List(2, 4, 6, 8, 10)

    // for comprehension without yield
    for {
      number <- numbers
    } {

    }


  end code

end Main
