package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplUnitTest extends AnyFlatSpec {
  val mockedCompanyValidator: CompanyValidator = mock[CompanyValidator]
  val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "Company" should "be created" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)

    when(mockedCompanyValidator.companyIsValid(company)) thenReturn true
    val result = companyImpl.createCompany(company)
    assert(result.isDefined)
  }

  "Company" should "not be created" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)

    when(mockedCompanyValidator.companyIsValid(company)) thenReturn false
    val result = companyImpl.createCompany(company)
    assert(result.isEmpty)
  }
}
