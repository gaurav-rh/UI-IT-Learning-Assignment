package com.knoldus.person

class Person {
  private var personName: String = ""
  private var personPassword: String = ""
  def getPersonName:String = personName
  def setPersonName(prsName:String): Unit = {
    this.personName = prsName
  }
  def setPersonPassword(prsPassword:String): Unit ={
      this.personPassword=prsPassword
    }
  def getPersonPassword:String = personPassword

 }
