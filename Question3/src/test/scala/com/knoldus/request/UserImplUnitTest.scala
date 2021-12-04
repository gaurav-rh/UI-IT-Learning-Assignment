package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidator: UserValidator = mock[UserValidator]
  val parthUser: User = User("Parth","Mittal","pallav.gupta@knoldus.com","knoldus")

  "User" should "be created" in {
    val userImpl = new UserImpl(mockedUserValidator)

    when(mockedUserValidator.isValid(parthUser)) thenReturn true
    val result = userImpl.createUser(parthUser)
    assert(result.isDefined)
  }

  "User" should "not be created" in {
    val userImpl = new UserImpl(mockedUserValidator)

    when(mockedUserValidator.isValid(parthUser)) thenReturn false
    val result = userImpl.createUser(parthUser)
    assert(result.isEmpty)
  }


}
