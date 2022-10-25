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
abstract class MyList {

  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements: String

  // polymorphic call
  override def toString = s"[$printElements]"
}


object Empty extends MyList {
  override def head: Nothing = throw new NoSuchElementException()


  override def tail: Nothing = throw new NoSuchElementException()

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  override def printElements: String =
    ""

}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) s"$h"
    else s"$h ${t.printElements}"
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).tail.head)
  println(list.isEmpty)

  println(list.toString)

}
