package com.knoldus.validator

import com.knoldus.models.User
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {
  val userValidator : UserValidator = new UserValidator()
  behavior of "UserValidatorTest"

  "A user" should "be valid if email is valid and company exists in database" in {
    val user: User = User("Gaurav", "Raj", "gauravraj.raj49@gmail.com", "Knoldus")
    assert(userValidator.isValid(user))
  }

  it should "be invalid if email is invalid" in {
    val user: User = User("Gaurav", "Raj", "gauravraj$raj49@gmail.in", "Knoldus")
    assert(!userValidator.isValid(user))
  }

  it should "be invalid if company name is not present in the database" in {
    val  user: User = User("Gaurav", "Raj", "gauravraj.raj49@gmail.org", "Armani")
    assert(!userValidator.isValid(user))
  }
  it should "be invalid if email is invalid and company name is not present in the database" in {
    val user: User = User("Gaurav", "Raj", "gauravraj.raj49@gmail.in", "Armani")
    assert(!userValidator.isValid(user))
  }
}
