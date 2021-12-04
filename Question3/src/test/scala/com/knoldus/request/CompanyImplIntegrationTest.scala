package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val companyValidator = new CompanyValidator()

  "Company" should "not be created as it already exists in DB" in {
    val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

   val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(company)
    assert(result.isEmpty)
  }

  "a company" should "not be created if email id is not valid" in {
    val googleCompany: Company = Company("Google", "google@gmail", "Gurugram")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(result.isEmpty)
  }

  "a company" should "not be created if it already exists and email id is invalid" in {
    val company: Company = Company("Knoldus", "knoldus@gmailcom", "Noida")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(company)
    assert(result.isEmpty)
  }

  "a company" should "be created" in {
    val googleCompany: Company = Company("Google", "google@gmail.com", "Gurugram")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(result.isDefined)
  }

}

