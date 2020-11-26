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

  //single-class inheritance with multi-trait = "mixing"
  class Crocodile extends Animal with Carnivore { // i.e. scala provides multi class/interface inheritance
    override def eat(animal: Animal) = println("I'm eating you")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog  //infix notation = object method argument, only available with method with one arg




}
