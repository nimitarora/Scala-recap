package com.rockthejvm

object ObjectOrientation extends App{

  //class and instance
  class Animal{
    //define fields
    val food: String = "food"
    //define methods
    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal

  //inheritance
  //passing parameters to class
  class Dog(name: String) extends Animal

  val aDog = new Dog("Lassie")
  //constructor argument is NOT A MEMBER - to do that you need to add val to it in definition

  class Cat(val name:String) extends Animal // Now it is member of class
  val aCat = new Cat("Lus")

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Casper")
  aDeclaredAnimal.eat // at compile time - it will refer to superclass function

  //abstract class
  abstract class WalkingAnimal{
    val hasLegs = true  //by default public therefore no public keyword (private, protected can be used)
    def walk(): Unit
  }   // whichever class inherits it have to override walk() function

  // Interface = ultimate abstract type
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  trait Philospher{
    def ?!(thought: String): Unit // ?!, !, ? are VALID method names
  }

  //single-class inheritance with multi-trait = "mixing"
  class Crocodile extends Animal with Carnivore with Philospher { // i.e. scala provides multi class/interface inheritance
    override def eat(animal: Animal) = println("I'm eating you")

    override def ?!(thought: String): Unit = println(s"I am thinking about $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog  //infix notation = object method argument, only available with method with one arg
  aCroc ?! "Swimming"

  // ##operators in scala are actually methods## //
  val basicMath = 1+2
  val anotherbasicMath = 1 +(2) //both are equivalent

  //anonymous function
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("Anonymous class")
  }/*
   Compiler -
   class Carnivore_Anonymous_43554 extends Carnivore{
    override def eat(animal: Animal): Unit = println("Anonymous class")
   }
   and then intiatiate it
   val dinosaur = new Carnivore_Anonymous_43554
   */

  //SINGLETON OBJECT
  object MySingleton {    // it is the only instance of MySingleton type
    val myVal = 4353
    def mySpecialMethod(): Int = 3452
    def apply(x: Int): Int = x + 1    //special method available in scala
  }
  MySingleton.mySpecialMethod()     // to call method in SINGLETON object

  MySingleton.apply(34)
  MySingleton(34)     // equivalent to MySingleton.apply(34)

  //Singleton object and class of same name can exist in same file and called COMPANIONS
  //COMPANIONS can access fields and methods of each other

  object Animal {
    // Singleton Animal and instances of Animal class are different things
    val canLiveInfinitely = false
  }
  val animalsCanLiveInfinitely = Animal.canLiveInfinitely //accessed in same way as static methods or fields are accessed in C++
  
  /*
  case classes = lightweight data structures with some boilerplate
  - sensible equals and hash code
  - serialization
  - contains companion with apply
  - pattern matching
   */

  case class Person(Name : String, Age: Int)

  // case class contains apply in companion which instantiates below without using new keyword
  // can be constructed without the keyword new
  val zack = Person("Zack", 16)     //Person.apply("Bob",18)

  //EXCEPTIONS
  try{
    // code that can throw an exception
    val x:String = null
    x.length
  }catch{
    case e: Exception => "SOme error message"
  }finally {
    // execute some code no matter what
  }

  //GENERICS
  abstract class MyList[T]
  {
    def head: T
    def tail: MyList[T]
  }

  //LIST
  //using generic type with a concrete type
  val aList : List[Int] = List(1,2,3)
  val first = aList.head
  val rest = aList.tail

  //Point 1: in scala we usually operate with IMMUTable values/objects

  //Point 2: Scala is closest to Object Oriented idea

}
