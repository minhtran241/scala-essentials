package lectures.OOP

/**
 * ALL OPERATORS ARE METHODS
 *
 * @author Minh Tran
 * @version 10/25/2022
 */

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie.equals(favoriteMovie)

    def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person =
      new Person(s"${this.name} (${nickname})", this.favoriteMovie, this.age)


    def unary_! : String = s"$name, how are you?"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def learns(thing: String) = s"$name is learning $thing"

    def learnsScala = this learns "Scala"

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie."

    def apply(n: Int): String = s"${this.name} watched ${this.favoriteMovie} $n times."
  }

  val scala = new Person("Scala", "Inception")
  println(scala.likes("Inception"))
  println(scala likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)
  // work with methods have only 1 parameter

  // "operator" in Scala
  val java = new Person("Java", "Fight Club")
  println(scala + java)
  println(scala.+(java))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  println(y)
  // unary_prefix only works with - + ~ !

  println(!scala)
  println(scala.unary_!)

  // postfix notation (methods without parameter)
  println(scala.isAlive)
  println(scala isAlive)

  // apply
  println(java.apply())
  println(java()) // equivalent

  /*
      1.  Overload the + operator
          mary + "the rockstar" => new person "Mary (the rockstar)"
      2.  Add an age to the Person class
          Add a unary + operator => new person with the age + 1
          +mary => mary with the age incrementer
      3.  Add a "learns" method in the Person class => "Mary learns Scala"
          Add a learnsScala method, calls learns method with "Scala".
          Use it in postfix notation.
      4.  Overload the apply method
          mary.apply(2) => "Mary watched Inception 2 times"
     */
  println((scala + "the Rockstar").apply())
  println((+scala).age)
  println(scala learnsScala)
  println(scala(10))
}
