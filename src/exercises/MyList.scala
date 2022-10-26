package exercises

/**
 * head = first element of the list
 * tail = remainder of the list
 * isEmpty = is this list empty
 * add(int) => new list with this element added
 * toString => a string representation of the list
 *
 * @author Minh Tran
 * @version 10/25/2022
 */
abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  // polymorphic call
  override def toString = s"[$printElements]"
}


object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()


  override def tail: Nothing = throw new NoSuchElementException()

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] =
    new Cons(element, Empty)

  override def printElements: String =
    ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] =
    new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) s"$h"
    else s"$h ${t.printElements}"
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
