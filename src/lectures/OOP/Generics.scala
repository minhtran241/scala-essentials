package lectures.OOP

object Generics extends App {
  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
  }
  /*
  A = Cat
  B = Animal
   */

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovarianceList[+A]

  val animal: Animal = new Cat
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]
  // animalList.add(new Dog) => return a list of Animal

  // 2. No = INVARIANCE
  class InvariantList[A]

  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. CONTRAVARIANCE
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)
}
