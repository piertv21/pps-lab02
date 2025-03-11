package task2

object Lab2 extends App:

  // Task 1
  println("Hello Scala")

  // Task 2
  def div(x: Double, y: Double): Double = x / y
  println(div(10, 2))
  def curriedDiv(x: Double)(y: Double): Double = x / y
  println(curriedDiv(10)(2))

  // Task 3.a
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

  // Task 3.b
  def neg(pred: String => Boolean) =
    (s: String) => !pred(s)
  val isShort: String => Boolean = _.length < 5
  val isNotShortMethod = neg(isShort)
  println(isNotShortMethod("hello")) // true

  val negLambda: (String => Boolean) => (String => Boolean) =
    pred => s => !pred(s)
  val isNotShortLambda = negLambda(isShort)
  println(isNotShortLambda("hi")) // false

  // Task 3.c
  def negGenerics[X](pred: X => Boolean) =
    (s: X) => !pred(s)
  val isNotShortMethodGeneric = negGenerics(isShort)
  println(isNotShortMethodGeneric("hello")) // true

  // Task 4
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  println(p1(1)(1)(1)) // true
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  println(p2(1, 1, 3)) // false
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  println(p3(1)(1)(1)) // true
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z
  println(p4(1, 1, 3)) // false

  // Task 5
  def compose(f: Int => Int, g: Int => Int): Int => Int = f compose g
  println(compose(_ - 1, _ * 2)(5)) // 9
  def genericCompose[X](f: X => X, g: X => X): X => X = f compose g
  println(genericCompose[Int](_ - 1, _ * 2)(10)) // 19

  // Task 6
  def composeThree[A, B, C, D](f: C => D, g: B => C, h: A => B): A => D = f compose g compose h
  println(composeThree[Int, Int, String, String](_ + "!", _.toString, _ * 2)(3)) // "6!"
  // No, it is not possible

  // Task 7
  def power(base: Double, exponent: Int): Double =
    if exponent == 0 then 1
    else base * power(base, exponent - 1)
  println(power(3, 3)) // 27.0

  // With tail recursion
  def powerWithTailRecursion(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def _pow(base: Double, exponent: Int, acc: Double): Double = exponent match
      case 0 => acc
      case _ => _pow(base, exponent - 1, acc * base)
    _pow(base, exponent, 1)
  println(powerWithTailRecursion(3, 3)) // Output: 27.0

  // Task 8
  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def _reverseNumber(n: Int, acc: Int): Int = n match
      case 0 => acc
      case _ => _reverseNumber(n / 10, acc * 10 + n % 10)
    _reverseNumber(n, 0)
  println(reverseNumber(12345)) // 54321