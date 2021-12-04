package com.knoldus.validator
import com.knoldus.person.Person

//import scala.util.matching.Regex
class PersonValidator {
    def personValidator(personObject:Person):Boolean = {
      if((personObject.getPersonName.length > 5) && personObject.getPersonName.contains(" "))
        true
      else
       false
    }

    def personPasswordValidator(personObject:Person):Boolean = {
      val password = personObject.getPersonPassword
      val regexString = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$"
      if(password.matches(regexString) && !password.contains(" "))
        true
      else
        false
    }

    //def personPasswordIntegerValid

  /*  def personPasswordSpaceValidator(personObject:Person):Boolean ={
      if(personObject.getPersonPassword.contains(" "))
        false
      else
        true
    }
*/

}
