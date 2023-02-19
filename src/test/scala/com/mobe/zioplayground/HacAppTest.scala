package com.mobe.zioplayground

import com.mobe.zioplayground.HacApp.result
import zio.{Console, Task, ZEnvironment, ZIO}
import zio.test.*
import HacConsole.*

object HacConsoleTest extends LoginService:
  override def login(name: String, password: String): Task[Token] =
    ZIO.succeed(Token("some token"))
    
object HacAppTest extends ZIOSpecDefault:
  def spec = suite("Login")(
    test("fetch csrf token") {
      for {
        output <- result.provideEnvironment(ZEnvironment(HacConsoleTest))
      } yield assertTrue(output == Token("some token"))
    }
  )
