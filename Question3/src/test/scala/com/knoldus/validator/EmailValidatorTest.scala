package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec
class EmailValidatorTest extends AnyFlatSpec {
  "an email" should "be Valid" in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav@gmail.com")
    assert(result)
  }

  "an email" should "be Valid with multiple domain" in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav@gmail.org.com")
    assert(result)
  }

  "an email" should "be Valid with dot in user" in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav.raj@gmail.com")
    assert(result)
  }

  "an email" should "be Valid with underscore character" in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav_raj@gmail.com")
    assert(result)
  }

  "an email" should "be Valid with dash character" in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav-raj@gmail.com")
    assert(result)
  }

  "an email" should "be Inalid without character @" in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav.gmail.com")
    assert(!result)
  }

  "an email" should "be Inalid without character '.' " in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav@gmailcom")
    assert(!result)
  }

  "an email" should "be Inalid with tld (Top Level domain) start with dot " in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav@.gmail.com")
    assert(!result)
  }

  "an email" should "be Inalid with No character before @ " in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("@gmail.com")
    assert(!result)
  }

  "an email" should "be Inalid with \".b\" is not a valid tld" in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid("gaurav@gmail.b")
    assert(!result)
  }

  "an email" should "be Inalid with an email  start with \".\" " in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid(".gaurav@gmail.com")
    assert(!result)
  }

  "an email" should "be Inalid as here the regular expression only allows character, digit, underscore, and dash  " in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid(".gaurav()@gmail.com")
    assert(!result)
  }

  "an email" should "be Inalid with double dots " in {
    val emailValidatorObject = new EmailValidator()
    val result = emailValidatorObject.emailIdIsValid(".gaurav..rh@gmail.com")
    assert(!result)
  }

}
