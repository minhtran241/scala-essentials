package lectures.functionalProgramming

object WhatsAFunction extends App {
  // use functions as first class elements
  // problem:  oop

  val doubler = new Function[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new ((Int, Int) => Int) {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //  Function types Function2[A, B, R] === (A, B) => R

  //  ALL SCALA FUNCTIONS ARE OBJECTS or INSTANCES DERIVED FROM Function1, Function2,...

  /*
    1.  a function which takes 2 strings and concatenates them
    2.  transform the MyPredicate and MyTransformer into function types
    3.  define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1.concat(v2)
  }

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Int => Int => Int = x => {(y: Int) => y + x}

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function

}

trait MyFunction[A, B] {
  def apply(element: A): B
}