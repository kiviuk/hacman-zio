package com.mobe.zioplayground

object Namcah:

  enum LoginError:

    case AuthenticationError

  case class Token(tokenId: String)

  enum Command[R]:
    case FetchTokenCommand extends Command[Token]
    case Login(loginName: String, password: String) extends Command[Token]
    case RunScript(command: String) extends Command[String]

  def execute[R](command: Command[R]): Either[LoginError, R] =
    import Command.*
    command match
      case FetchTokenCommand =>
        println("fetching token")
        Right(Token(""))

      case Login(loginName, password) => {
        println(s"login=$loginName, pwd=$password")
        Right(Token(""))
      }
      case _ => {
        println(s"NotImplementedExceptions")
        Left(LoginError.AuthenticationError)
      }
