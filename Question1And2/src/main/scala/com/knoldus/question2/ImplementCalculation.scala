package com.knoldus.question2

class ImplementCalculation extends Calculation {

  def numberIsPalindrome(number:Int):Boolean = {
    var sum = 0
    var number1=number
    while(number1>1)
      {
        val remainder = number1%10
        sum=sum*10 + remainder
        number1=number1/10
      }
    if(number==sum)
      true
    else
      false
  }

  def calculateFactorial(number:Int):Int= {
    val number1 = number
    if(number>1)
      number*calculateFactorial(number-1)
    else if(number==0)
      1
    else
      number1
    }


}

/*object ImplementCalc{
  def main(args:Array[String]): Unit ={
    val implementationObject = new ImplementCalculation()
    val implementaionObjectFactorial = new ImplementCalculation()
    val result = implementationObject.numberIsPalindrome(2002)
    printf {
      result.toString
    }
   printf(implementaionObjectFactorial.calculateFactorial(0).toString)
  }
}
*/