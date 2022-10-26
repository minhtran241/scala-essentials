package lectures.OOP

/**
 * @author Minh Tran
 * @version 25/10/2022
 */

object CaseClasses extends App {
  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameter are fields
  val scala = new Person("Scala", 18)
  println(scala.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(scala)

  // 3. equals and hashCode implemented out of the box
  val scala2 = new Person("Scala", 18)
  println(scala == scala2) // true

  // 4. Case classes have handy copy method
  val scala3 = scala.copy(age = 45)
  println(scala3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val java = Person("Java", 34)
  println(java.getClass) // Person

  // 6. Case classes are serializable
  // Akka

  // 7. Case classes have extractor patterns = Case classes can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList - use case classes and case objects
   */
}
