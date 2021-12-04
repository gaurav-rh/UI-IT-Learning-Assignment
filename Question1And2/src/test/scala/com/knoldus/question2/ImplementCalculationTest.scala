package com.knoldus.question2

import org.scalatest.flatspec.AnyFlatSpec
//import com.learningTest.question2.ImplementCalculation
class ImplementCalculationTest extends AnyFlatSpec {
  "a number" should "be valid palindrome number" in{
    val implementCalculationObject = new ImplementCalculation()
    assert(implementCalculationObject.numberIsPalindrome(2002))
  }

  "A number" should "be palindrome as 0 is palindrome" in {
    val implementCalculationObject = new ImplementCalculation()
    assert(implementCalculationObject.numberIsPalindrome(0))
  }

  "A number" should "not be palindrome as it is negative" in {
    val implementCalculationObject = new ImplementCalculation()
    assert(!implementCalculationObject.numberIsPalindrome(-2002))
  }


  "a number" should "be Invalid palindrome number" in{
    val implementCalculationObject = new ImplementCalculation()
    assert(!implementCalculationObject.numberIsPalindrome(20021))
  }

  "factorial of a number" should "be valid " in{
    val implementCalculationObject = new ImplementCalculation()
    var result = true
    if(implementCalculationObject.calculateFactorial(5) ==120)
      result=true
    else
      result=false

    assert(result)
  }

  "factorial of a number Zero" should "be valid if result is 1" in{
    val implementCalculationObject = new ImplementCalculation()
    var result = true
    if(implementCalculationObject.calculateFactorial(0) ==1)
      result=true
    else
      result=false

    assert(result)
  }

  "factorial of a number" should "be Invalid " in{
    val implementCalculationObject = new ImplementCalculation()
    var result = true
    if(implementCalculationObject.calculateFactorial(10) ==362880)
      result=true
    else
      result=false

    assert(!result)
  }
}
