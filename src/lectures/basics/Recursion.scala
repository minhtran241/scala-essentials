package lectures.basics

import scala.annotation.tailrec

/**
 * TAIL RECURSION = use recursive call as the LAST expression
 *
 * @author Minh Tran
 * @version 10/24/2022
 */
object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n - First, need factorial of ${n - 1}...")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of $n")
      result
    }
  //  println(factorial(10))
  //  println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
      // TAIL RECURSION = use recursive call as the LAST expression
      // the current stack frame is replaced with new stack frame
      // instead of adding one more stack frame to the stack
    }

    factHelper(n, 1)
  }
  /*
        anotherFactorial(10) = factHelper(10, 1)
        = factHelper(9, 10 * 1)
        = factHelper(8, 9 * 10 * 1)
        = factHelper(7, 8 * 9 * 10 * 1)
        = ...
        = factHelper(2, 3 * 4 * ... * 10 * 1)
        = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
        = 1 * 2 * 3 * 4 * ... * 10
   */
  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_RECURSION.

  /*
      1.  Concatenate a string n times
      2.  IsPrime function tail recursive
      3.  Fibonacci function, tail recursive.
  */
  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n - 1, aString.concat(accumulator))

  println(concatenateTailrec("hello", 5, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: BigInt, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) isStillPrime
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeUntil(n / 2, isStillPrime = true)
  }

  println(isPrime(37)) // true
  println(isPrime(2003)) // true
  println(isPrime(37 * 17)) // false

  def fibonacci(n: Int): BigInt = {
    @tailrec
    // last: fibonacci(n)
    // nextToLast: fibonacci(n - 1)
    def fibonacciTailrec(i: Int, last: BigInt, nextToLast: BigInt): BigInt =
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }
  // 1 1 2 3 5 8 13 21
  println(fibonacci(8))
}