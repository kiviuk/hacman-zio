package com.mobe
package zioplayground

import com.mobe.zioplayground.HacConsoleLive.login
import zio.*
import zio.http.model.Headers
import zio.http.netty.client.{ NettyClientDriver, NettyConnectionPool }
import zio.http.{ Client, ClientConfig, ClientSSLConfig }
import zio.internal.ansi.Color

import java.io.IOException

case class Token(token: String)

object HacConsole:
  trait LoginService:
    def login(name: String, password: String): Task[Token]

import com.mobe.zioplayground.HacConsole.*

object HacConsoleLive extends LoginService:
  override def login(name: String, password: String): Task[Token] =
    Console
      .readLine
      .map(token => Token(token))
      .refineOrDie {
        case e: IOException => e
      }

object HacApp extends ZIOAppDefault:
  val result: Task[Token] =
    for {
      _ <- Console.print("Login: ")
      token <- login("", "")
      _ <- Console.printLine(s"TOKEN: $token")
    } yield token

  def run: Task[Token] =
    runInternal(HacConsoleLive)

  private def runInternal(service: LoginService) =
    result.provideEnvironment(ZEnvironment(service))
