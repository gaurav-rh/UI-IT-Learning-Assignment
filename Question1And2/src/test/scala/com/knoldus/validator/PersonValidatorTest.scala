package com.knoldus.validator

import com.knoldus.person.Person
import org.scalatest.flatspec.AnyFlatSpec

class PersonValidatorTest extends AnyFlatSpec {
  "a person " should "have valid name" in {
    val personObject1 = new Person()
    personObject1.setPersonName("Gaurav Raj")
    val personValidator = new PersonValidator()
    val result = personValidator.personValidator(personObject1)
    assert(result)
  }

  "a person " should "have valid name invalid" in {
    val personObject1 = new Person()
    personObject1.setPersonName("gauravraj")
    val personValidator = new PersonValidator()
    val result = personValidator.personValidator(personObject1)
    assert(!result)
  }

  "a password " should "be valid for person" in {
    val personObject1 = new Person()
    val personValidatorObject = new PersonValidator()
    personObject1.setPersonName("Gaurav Raj Happy")
    personObject1.setPersonPassword("Password@123")
    val result1 = personValidatorObject.personPasswordValidator {
      personObject1
    }
    assert(result1)
  }


  "a password with space" should "be invalid for person" in {
    val personObject1 = new Person()
    val personValidatorObject = new PersonValidator()
    personObject1.setPersonName("Bhavya Chanan")
    personObject1.setPersonPassword("Password@ 123")
    val result1 = personValidatorObject.personPasswordValidator(personObject1)
    assert(!result1)
  }

  "a password with length not between 8 and 16" should "be invalid for person" in {
    val personObject1 = new Person()
    val personValidatorObject = new PersonValidator()
    personObject1.setPersonName("Parth Mittal")
    personObject1.setPersonPassword("Password@123grhpdsrs")
    val result1 = personValidatorObject.personPasswordValidator(personObject1)
    assert(!result1)
  }
  "a password without uppercase character" should "be invalid" in {
    val personObject = new Person()
    val personValidatorObject = new PersonValidator()
    personObject.setPersonName("Mohneesh Poswal")
    personObject.setPersonPassword("baklol@123")
    val result = personValidatorObject.personPasswordValidator(personObject)
    assert(!result)
  }

  "a password without lowercase character" should "be invalid" in {
    val personObject = new Person()
    val personValidatorObject = new PersonValidator()
    personObject.setPersonName("Arihant Jain")
    personObject.setPersonPassword("B2AKLOL@123")
    val result = personValidatorObject.personPasswordValidator(personObject)
    assert(!result)
  }

  "a password without number character" should "be invalid" in {
    val personObject = new Person()
    val personValidatorObject = new PersonValidator()
    personObject.setPersonName("Rishabh Shrivastava")
    personObject.setPersonPassword("BAKLOL@abcb")
    val result = personValidatorObject.personPasswordValidator(personObject)
    assert(!result)
  }

  "a password without special character" should "be invalid" in {
    val personObject = new Person()
    val personValidatorObject = new PersonValidator()
    personObject.setPersonName("Rishabh Shrivastava")
    personObject.setPersonPassword("BAKLOLab123")
    val result = personValidatorObject.personPasswordValidator(personObject)
    assert(!result)
  }

}