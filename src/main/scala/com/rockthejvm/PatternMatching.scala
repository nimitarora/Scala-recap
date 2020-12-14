package com.rockthejvm

object PatternMatching extends App{

  //MATCH EXPRESSION
  val anInteger = 3
  val order = anInteger match{
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => "Default case"
  }

  // PATTERN MATCHING

  // Case class decomposition
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 23)

  val greetPerson = bob match{
    case Person(n,a) => s"$n is $a years old"
    case _ => "Default"
  }

  // Decomposition of tuples
  val aTuple = ("New","Rock")
  val tupleDesc = aTuple match {
    case (band, genre) => s"$band sings $genre"
    case _ => "Default"
  }

  // Decomposition of Lists
  val aList = List(1,2,3)
  val desc = aList match {
    case List(_, 2, _) => "List contains 2 in it"
    case _ => "Default case"
  }




}
