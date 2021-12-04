package com.knoldus.validator

import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {
  val companyValidator = new CompanyValidator()
  "A company" should "be valid if it does not exist in the database and its email is valid" in {
    val company = Company("Armani", "armani@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(result)
  }

  "a company" should "be invalid if it exists in the database and its email is invalid" in {
    val company = Company("Philips", "Phi$llips@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

  "a company" should "be invalid if it already exist in the database" in {
    val company = Company("Knoldus", "knoldus@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

  it should "be valid if its email is Valid" in {
    val company = Company("Armani", "armani.123@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(result)
  }
}
