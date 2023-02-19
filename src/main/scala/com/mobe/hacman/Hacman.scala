package com.mobe.hacman

import zio.*

case class Token(id: String)

case class Login(
  name: String,
  password: String
)

trait LoginService:
  def getToken(login: Login): Task[Token]

case class LoginServiceLive() extends LoginService:
  override def getToken(login: Login): Task[Token] =
    ZIO.attemptBlocking(scala.io.StdIn.readLine()).map(token => Token(token))

object LoginServiceLive:
  val layer:ULayer[LoginServiceLive] = 
    ZLayer.succeed(LoginServiceLive())

object LoginService:
  def getToken(login: Login): ZIO[LoginService, Throwable, Token] =
    ZIO.serviceWithZIO[LoginService](_.getToken(login))

object Hacman extends ZIOAppDefault:

  val app: ZIO[LoginService, Throwable, Token] =
    for {
      token <- LoginService.getToken(Login("", ""))
      _ <- Console.printLine(token)
    } yield
      token

  def run: ZIO[Any, Throwable, Token] =
    app.provide(
      LoginServiceLive.layer
    )

