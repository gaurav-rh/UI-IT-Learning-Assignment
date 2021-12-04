package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {
  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val userValidator = new UserValidator()
  val userImpl = new UserImpl(userValidator)

  "a User" should "not be created as company does not exists in DB" in {
    val gauravUser: User = User("Gaurav","Raj","Google","gaurav.raj@gmail.com")

    val result = userImpl.createUser(gauravUser)
    assert(result.isEmpty)
  }

  "a User" should "not be created as email id is not valid" in {
    val parthUser: User = User("Parth","Mittal","pragati.aggarwal@knoldus","Knoldus")

    val result = userImpl.createUser(parthUser)
    assert(result.isEmpty)
  }

  "a User" should "not be created as company does not exists in DB and email id is not valid" in {
    val nishaUser: User = User("Nisha","Kaushik","nishu.kumari@microsoft","Microsoft")

    val result = userImpl.createUser(nishaUser)
    assert(result.isEmpty)
  }

  "a User" should "be created" in {
    val rishabhUser: User = User("Rishabh","Shrivastava","pallavgupta@knoldus.com","Knoldus")

    val result = userImpl.createUser(rishabhUser)
    assert(result.isDefined)
  }

}
