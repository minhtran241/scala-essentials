package lectures.basics

/**
 * By-name parameters are evaluated every time they are used.
 * They won’t be evaluated at all if they are unused.
 * This is similar to replacing the by-name parameters with the passed expressions.
 * They are in contrast to by-value parameters.
 * To make a parameter called by-name, simply prepend => to its type.
 *
 * @author Minh Tran
 * @version 10/25/2022
 */
object CBNvsCBV extends App {
  def callByValue(x: Long): Unit = {
    println(s"by value: $x")
    println(s"by value: $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"by name: $x")
    println(s"by name: $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

//  printFirst(infinite(), 34)
  printFirst(34, infinite())
}
