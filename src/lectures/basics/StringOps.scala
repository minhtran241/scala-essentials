package lectures.basics

/**
 * @author Minh Tran
 * @version 10/25/2022
 */
object StringOps extends App {
  val str: String = "Hello, I am a Scala expert"

  // JVM
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList) // List(Hello,, I, am, a, Scala, expert)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toUpperCase())
  println(str.length)

  // Scala
  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // a2z
  println(str.reverse) // trepxe alacS a ma I ,olleH
  println(str.take(2)) // He

  // Scala-specific: String interpolator.
  val name = "Scala"
  val age = 12
  val greeting = s"Hello, my name is $name, I am $age years old."
  val anotherGreeting = s"Hello, my name is $name, " +
    s"I will be turning ${age + 1} years old."
  println(anotherGreeting)

  // F-interpolator
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute."
  println(myth) // Scala can eat 1.20 burgers per minute.

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}

