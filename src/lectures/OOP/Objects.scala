package lectures.OOP

/**
 * @author Minh Tran
 * @version 10/25/2022
 */

object Objects extends App {
  // NOTE: SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // NOTE: TO USE CLASS-LEVEL FUNCTIONALITY ("static") IN SCALA WE USE OBJECT
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Scala")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // class Person & object Person: COMPANIONS (same scope + same name)

  println(Person.N_EYES)
  println(Person.canFly)

  // NOTE: Scala object = SINGLETON INSTANCE
  // Scala object has only 1 instance. "scala" and "java" point to the same instance
  val python = Person
  val golang = Person
  println(python.equals(golang)) // true

  val js = new Person("JavaScript")
  val java = new Person("Java")
  println(js.equals(java))

  val scala = Person(java, js)

  // Scala Application = Scala object with
  // def main(args: Array[String]): Unit
}
