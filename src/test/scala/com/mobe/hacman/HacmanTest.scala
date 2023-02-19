package com.mobe.hacman

import zio.test.ZIOSpecDefault
import zio.{Task, ULayer, ZIO, ZLayer}
import zio.*
import zio.test.*
import zio.test.Assertion.*


case class LoginServiceTest() extends LoginService:
  override def getToken(login: Login): Task[Token] =
    ZIO.succeed(Token("some token"))

object LoginServiceTest:
  val layer:ULayer[LoginServiceTest] = 
    ZLayer.succeed(LoginServiceTest())

object HacmanTest extends ZIOSpecDefault:

  def spec = suite("App Spec")(
    test("should yield some token") {
      for {
        output <- Hacman.app
      } yield assertTrue(output == Token("some token"))
    }
  ).provideLayer(LoginServiceTest.layer)
