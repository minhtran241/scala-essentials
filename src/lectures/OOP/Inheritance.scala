package lectures.OOP

/**
 * @author Minh Tran
 * @version 10/25/2022
 */
object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"

    def eat = println("nom")
  }

  sealed class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {

    //    override val creatureType: String = "domestic"

    override def eat: Unit = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution  (road: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat // crunch, crunch

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - "sealed" the class = extend classes in THIS FILE, prevent extension in other files
}
