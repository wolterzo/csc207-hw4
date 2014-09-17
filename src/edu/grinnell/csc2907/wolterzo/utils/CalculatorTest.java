package edu.grinnell.csc2907.wolterzo.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest
{

  @Test
  public void testEval0()
  {
    assertEquals(new BigInteger("10"),
                 Calculator.eval0("5 + 6 - 1 / 2 ^ 2 - 15"));
    assertEquals(new BigInteger("15"), Calculator.eval0("3 * 5"));
    assertEquals(new BigInteger("0"),
                 Calculator.eval0("5 + 6 - 1 / 2 ^ 2 - 15 * 0"));
  } // testEval0

  @Test
  public void testEval1()
  {
    assertEquals("4/5", Calculator.eval1("5/10 - 1/10 * 2/1").toString());
    assertEquals("3/2", Calculator.eval1("8/10 / 1/10 * 1/8 + 1/2").toString());
  } // testEval1

} // class CalculatorTest
