package lectures.basics

/**
 * @author Minh Tran
 * @version 10/24/2022
 */
object ValuesVariablesTypes extends App {
  // VALs are IMMUTABLE
  val x: Int = 42
  println(x)

  // COMPILER can auto-infer TYPE when omitted
  val y = 42

  val aString: String = "hello, this is a string"
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aShort: Short = 4532
  val aLong: Long = 33030393345029330L
  val aFloat: Float = 2.01f
  val aDouble: Double = 498.92

  // VARs are MUTABLE
  var aVariable: Int = 4
  aVariable = 5 // side effects

}
