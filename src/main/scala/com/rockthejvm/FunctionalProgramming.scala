package com.rockthejvm

object FunctionalProgramming extends App{

  val simpleIncrementer = new Function1[int, int] //takes int and returns int
  {
    override def apply(args: Int) : Int = args + 1
  }
  simpleIncrementer(23)   //24
  // all scala functions are instances of these FunctionX types

  val stringConcatenator = new function2[String, String, String]  //takes 2 strings and returns 1 string
  {
    override def apply(arg1: String, arg2: String): String = arg1+arg2
  }
  stringConcatenator("My name is", "Nimit")

  //syntax sugars
  val doubler : new Function1[Int,Int] = (x:Int) => 2 * x
  doubler(4)  //8
  /*
  equivalent to much longer
    new Function1[Int,Int]
    {
      override def apply(x: Int): Int = 2*x
    }
  */

  val doubler: Int => Int = (x:Int) => 2*x

  //HIGHER ORDER FUNCTIONS

  val aMappedList = List(1,2,3).map(x => x+1)
  //returns another List i.e. List(2,3,4)

  val flatMappedList = List(1,2,3).flatMap(x => List(x,2*x))
  //result will be concatenated in a single list
  //List(1,2,2,4,3,6)

  val filteredList = List(1,2,3,4,5).filter(x=> x <3)
  val filteredList1 = List(1,2,3,4,5).filter(_ x <3)
  //result List(1,2)

  // all pairs between numbers 1,2,3 and letters 'a','b','c'
  val allPairs = List(1,2,3).flatMap(numbers => List('a', 'b', 'c').map(letters => s"$numbers-$letters"))
  //result - List(1-a, 1-b, 1-c, 2-a, 2-b, 2-c, 3-a ,3-b, 3-c)
  //alternative
  val alternativePair = for{
    numbers <- List(1,2,3)
    letters <- List('a', 'b', 'c')
  }yield s"$numbers-$letters"
  //equivalent to map/flatmap chain above
  //compiler converts for to map/flatmap chain

  /*
  Collections
   */

  //LISTS
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head   // 1
  val rest = aList.tail       //List(2,3,4,5)
  val aPrependList = 0 :: aList     // List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6    //List(0,1,2,3,4,5,6)

  //SEQUENCES
  val aSequence: Seq[Int] = Seq(1,2,3)
  val accessElement = aSequence(1)    // element at index 1 i.e. 2

  //VECTORS : fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  //SETS
  val aSet = Set(1,2,3,4,1,2,3)       // Set(1,2,3,4)
  val has5 = aSet.contains(5)       // false
  val addValue = aSet + 5         // Set(1,2,3,4,5)
  val removeValue = aSet - 3       // Set(1,2,4)

  //RANGES
  val aRange = 1 to 1000
  val twoby2 = aRange.map(x => x*2).toList      //List(2,4,6,8,...)

  //TUPLES
  val aTuple = ("Nimit", "Rohit". 3242)

  //MAPS
  val aPhoneBook: Map[String, Int] = Map(
    ("John", 8349873)
    ("Daniel" -> 874923)
  )








}




