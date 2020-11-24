package com.rockthejvm

object Basics extends App{

  //Int, Boolean, Float, Char, Double, String, Unit(void of other languages)
  //defining value
  val age:Int = 21
  val aBoolean = false //type mentioning is optional

  //string and string operations
  val aString = "Scala basics"
  val aComposedString = "Scala" + "basics"
  val anInterpolatedString = s"My age is $age"

  //expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  //if-expression
  val ifExpression = if (age > 25) 11 else 111
  val chainedIfExpression =
    if (age > 55) 11
    else if (age >35) 22
    else if (age >15) 33
    else 0

  //code blocks
  val aCodeBlock = {
    //definitions
    val aLocalValue = 32

    //value of block is value of its last expression
    aLocalValue + 3
  }

  //define function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  //recursive functions
  def factorial(n: Int): Int =
    if(n <= 1) 1
    else n * factorial(n-1)

  //Unit type (void)
  def myUnitFunction(): Unit = {
    println("I dont use Unit much")
  }
  val unit = () // THIS IS RETURNED BY UNIT VALUE
}
