package lectures.basics

import scala.annotation.tailrec

/**
 * 1. pass in every leading argument
 * 2. name the arguments
 *
 * @author Minh Tran
 * @version 25/10/2022
 */
object DefaultArgs extends App {
  @tailrec
  def trFact(n: Int, accumulator: Int = 1): Int =
    if (n <= 1) accumulator
    else trFact(n - 1, n * accumulator)

  val fact10 = trFact(10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println("saving picture...")

  // Error: Compiler assumes that 800 is the first argument (format)
//  savePicture(800)
  // Right
  savePicture(width = 800)

  /*
    1. pass in every leading argument
    2. name the arguments
   */

  savePicture(height = 600, width = 800, format = "bmp")

}
