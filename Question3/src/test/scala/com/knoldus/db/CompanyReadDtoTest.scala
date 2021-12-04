package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec

class CompanyReadDtoTest extends AnyFlatSpec {
  "a company" should "exist" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Knoldus")
    assert(result.isDefined)
  }
  "Company" should "not exist" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Google")
    assert(result.isEmpty)
  }


}
