package com.mobe
package zioplayground

object Main:

  trait NewType[Wrapped]:

    opaque type Type = Wrapped

    inline def apply(w: Wrapped): Type = w

    extension (t: Type) inline def value: Wrapped = t

    given(using CanEqual[Wrapped, Wrapped]): CanEqual[Type, Type] = CanEqual.derived

  val number:Int = 42

  def main(args: Array[String]): Unit =
    println("-" * 60)
    code(args)
    println("-" * 60)
  end main

  private def code(args: Array[String]): Unit =

    import com.mobe.zioplayground.Main.NewType

    println("Hi")

end Main
