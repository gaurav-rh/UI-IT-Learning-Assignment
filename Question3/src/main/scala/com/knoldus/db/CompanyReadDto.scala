package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyReadDto {

  val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val philipsCompany: Company = Company("Philips", "philips123@gmail.com", "Noida")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> company, "Philips" -> philipsCompany)

  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
