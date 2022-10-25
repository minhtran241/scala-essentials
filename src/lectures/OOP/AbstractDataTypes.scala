package lectures.OOP

/**
 * @author Minh Tran
 * @version 10/25/2022
 */
object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch, crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit

    val preferedMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit =
      println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile // I'm a croc and I'm eating Canine
  crocodile.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameter
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
}
