package task2

object Task2 extends App:

  // Ex 1
  println("Hello Scala")

  // Ex 2
  def div(x: Double, y: Double): Double = x / y
  def curriedDiv(x: Double)(y: Double): Double = x / y

  println(div(10, 2))
  println(curriedDiv(10)(2))

  // Ex 3.a
  // Lambda style
  val firstFunction: Int => String = _ match
    case n if n >= 0 => "positive"
    case n if n < 0 => "negative"

  println(firstFunction(1)) // positive
  println(firstFunction(-1)) // negative

  // Method style
  def secondFunction(n: Int): String = n match
    case n if n >= 0 => "positive"
    case n if n < 0 => "negative"

  println(secondFunction(5))
  println(secondFunction(-5))

  // Ex 3.b
  def neg(pred: String => Boolean) =
    (s: String) => !pred(s)

  val negLambda: (String => Boolean) => (String => Boolean) =
    pred => s => !pred(s)

  val isShort: String => Boolean = _.length < 5 // is short
  val isNotShortMethod = neg(isShort)
  val isNotShortLambda = negLambda(isShort)

  println(isNotShortMethod("hello")) // true
  println(isNotShortLambda("hi")) // false

  // Ex 3.c
  def negGenerics[X](pred: X => Boolean) =
    (s: X) => !pred(s)

  val isNotShortMethodGeneric = neg(isShort)
  println(isNotShortMethodGeneric("hello")) // true

  // Ex 4
