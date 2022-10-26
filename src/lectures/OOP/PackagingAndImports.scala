package lectures.OOP

import playground.{JavaScript, ScalaCharming => Scala}

import java.util.Date
import java.sql.{Date => SqlDate}

/**
 * Package = a group of definitions under the same name
 *
 * @author Minh Tran
 * @version 25/10/2022
 */

object PackagingAndImports extends App {
  // package members are accessible by their simple name
  val writer = new Writer("Scala", "Programmer", 2022)

  // import the package
  val js = new JavaScript // playground.JavaScript = fully qualified name

  // package are in hierarchy
  // matching folder structure and file system

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val scala = new Scala

  // 1. use FQ name
  val date = new Date
  //  val sqlDate = new java.sql.Date(2022, 5, 4)

  // 2. use aliasing
  val sqlDate = new SqlDate(2022, 5, 4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
