package task5

import org.junit.Assert.assertEquals
import org.junit.Test
import task2.Lab2.{Expr, ExprModule}

class Lab2Test:
  @Test def evaluateLiteral(): Unit =
    val expr = Expr.Literal(5)
    assertEquals(5, ExprModule.evaluate(expr))

  @Test def evaluateAddition(): Unit =
    val expr = Expr.Add(Expr.Literal(3), Expr.Literal(7))
    assertEquals(10, ExprModule.evaluate(expr))

  @Test def evaluateMultiplication(): Unit =
    val expr = Expr.Multiply(Expr.Literal(3), Expr.Literal(4))
    assertEquals(12, ExprModule.evaluate(expr))

  @Test def evaluateNestedExpression(): Unit =
    val expr = Expr.Add(Expr.Literal(2), Expr.Multiply(Expr.Literal(3), Expr.Literal(4)))
    assertEquals(14, ExprModule.evaluate(expr))

  @Test def showLiteral(): Unit =
    val expr = Expr.Literal(5)
    assertEquals("5", ExprModule.show(expr))

  @Test def showAddition(): Unit =
    val expr = Expr.Add(Expr.Literal(3), Expr.Literal(7))
    assertEquals("(3 + 7)", ExprModule.show(expr))

  @Test def showMultiplication(): Unit =
    val expr = Expr.Multiply(Expr.Literal(3), Expr.Literal(4))
    assertEquals("(3 * 4)", ExprModule.show(expr))

  @Test def showNestedExpression(): Unit =
    val expr = Expr.Add(Expr.Literal(2), Expr.Multiply(Expr.Literal(3), Expr.Literal(4)))
    assertEquals("(2 + (3 * 4))", ExprModule.show(expr))