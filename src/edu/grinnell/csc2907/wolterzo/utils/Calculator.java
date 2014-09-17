package edu.grinnell.csc2907.wolterzo.utils;

import java.math.BigInteger;

public class Calculator
{
  /**
   * Returns the result of evaluating a string, str. 
   * str must be an arithmetic expression whose numbers and spaces are
   * separated by spaces. 
   * Supports the following operations: +, -, *, /, and ^
   * @param str
   * @return BigInteger
   */
  public static BigInteger eval0(String str)
  {
    BigInteger result = new BigInteger("0");
    char curr;
    int last = 0;
    char op = '+';
    BigInteger currNum = new BigInteger("0");
    /*
     * Go through the string and calculate the result using the given numbers
     * and operators.
     */
    for (int i = 0; i < str.length(); i++)
      {
        curr = str.charAt(i);
        if (curr == '*' || curr == '/' || curr == '+' || curr == '-'
            || curr == '^')
          {
            currNum = new BigInteger(str.substring(last, i).trim());
            result = operate(result, op, currNum);
            last = i + 1;
            op = curr;
          } //if
      } // for
    /*
     * Operate on the last number in the string.
     */
    currNum = new BigInteger(str.substring(last).trim());
    result = operate(result, op, currNum);
    return result;
  }// eval0 (String)
  
  /**
   * Returns a fractional representation of an arithmetic expression in the 
   * given string.
   * str must be an arithmetic expression in which fractions and operators are
   * separated by spaces.
   * operations supported include: +, -, *, and /.
   * @param str
   * @return Fraction
   */
  public static Fraction eval1(String str)
  {
    Fraction result = new Fraction("0");
    char curr;
    int last = 0;
    char op = '+';
    Fraction currFrac = new Fraction("0");
    /*
     * Go through the string and calculate the result using the given fractions
     * and operators.
     */
    for (int i = 0; i < str.length(); i++)
      {
        curr = str.charAt(i);
        if ((curr == '*' || curr == '/' || curr == '+' || curr == '-' || curr == '^')
            && str.charAt(i + 1) == ' ')
          {
            currFrac = new Fraction(str.substring(last, i).trim());
            result = operate(result, op, currFrac);
            last = i+1;
            op = curr;
          } // if
      } // for
    /*
     * Find and operate on the last fraction in the string.
     */
    currFrac = new Fraction(str.substring(last).trim());
    result = operate(result, op, currFrac);
    return result;
  } // eval1(String)
  
  /**
   * Performs an operation between two fractions using the given operator. 
   * @param first
   * @param op
   * @param second
   * @return Fraction
   */
  public static Fraction operate(Fraction first, char op, Fraction second)
  {
    Fraction result = new Fraction("0");
    switch (op)
      {
        case '+':
          result = first.add(second);
          break;
        case '-':
          result = first.subtract(second);
          break;
        case '*':
          result = first.multiply(second);
          break;
        case '/':
          result = first.divide(second);
          break;
          /* Don't need exponentiation
        case '^':
          result = first.pow(Integer.valueOf(second.num.toString()));
          break;
          */
      } // switch
    return result;

  } // operate(Fraction, char, Fraction)
  
  /**
   * Performs an operation between two BigIntegers using the given operator.
   * @param first
   * @param op
   * @param second
   * @return BigInteger
   */
  public static BigInteger
    operate(BigInteger first, char op, BigInteger second)
  {
    BigInteger result = new BigInteger("0");
    switch (op)
      {
        case '+':
          result = first.add(second);
          break;
        case '-':
          result = first.subtract(second);
          break;
        case '*':
          result = first.multiply(second);
          break;
        case '/':
          result = first.divide(second);
          break;
        case '^':
          result = first.pow(Integer.valueOf(second.toString()));
          break;
      } // switch
    return result;
  } // operate(BigInteger, char, BigInteger)

} // class Calculator
