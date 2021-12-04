package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User

class UserValidator {
  def isValid(user : User): Boolean = {
    val companyValidator : CompanyReadDto = new CompanyReadDto()
    val emailValidator : EmailValidator = new EmailValidator()

    val validEmailId = emailValidator.emailIdIsValid(user.email)
    val validCompany = companyValidator.getCompanyByName(user.companyName)

    if(validEmailId && validCompany.isDefined)
      true
    else
      false
  }
}
