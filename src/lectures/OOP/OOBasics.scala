package lectures.OOP

/**
 * @author Minh Tran
 * @version 10/25/2022
 */

object OOBasics extends App {
  val person = new Person("Scala", 18) // all body code of Person executed
  println(person.x)
  person.greet("Minh Tran")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))

  val counter = new Counter // 0
  counter.inc.print // 1
  counter.inc.inc.inc.print // 3
  counter.inc(10).print // 10

}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2 // field
  println(1 + 3) // executed whenever an instance of Person is initialized

  // method
  def greet(name: String): Unit =
    println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit =
    println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("Scala")
}

// NOTE: class parameters are NOT FIELDS (Must add "val" to convert parameter -> field)

/*
  Novel and a Writer
  Writer: first name, surname, year
    - method fullName
  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, surName: String, val year: Int) {
  def fullName(): String = firstName + " " + surName
}

class Novel(name: String, year: Int, author: Writer) {
  val authorAge: Int = year - author.year

  def isWrittenBy(author: Writer): Boolean = this.author.equals(author)

  def copy(year: Int): Novel = new Novel(this.name, year, this.author)
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */
class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing...")
    new Counter(count + 1) // immutability
  }

  def dec = {
    println("decrementing...")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}
