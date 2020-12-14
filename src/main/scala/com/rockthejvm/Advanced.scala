package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App{

  /**
    lazy evaluation
   */
  val aLazyvalue = 22
  // evaluated only when called first time

  /**
   * Pseudo-Collections: Option, Try
   */

  def methodReturnNull(): String = "hello"
  val anOption = Option(methodReturnNull())
  // option = "collection" which contains atmost one element: Some(value) or None

  val stringProcessor = anOption match{
    case Some(string) => s"I obtained valid string $string"
    case None => "Nothing"
  }

  def methodReturnException(): String = throw RuntimeException
  val aTry = Try(methodReturnException())
  // Try - collection with either a value if code went well or an exception if code threw one

  /**
   * Evaluate something on another thread
   * (Asynchronous Programming)
   */
   // USING FUTURE

  val aFuture = Future({
     println("Loading")
     Thread.sleep(1000)
     println("Got a value")
     45
   })
  Thread.sleep(3000)


}
