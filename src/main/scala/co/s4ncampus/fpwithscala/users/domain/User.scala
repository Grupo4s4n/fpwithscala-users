package co.s4ncampus.fpwithscala.users.domain

/**
  * User Class to serialize with the User table 
  *
  * @param id
  * @param legalId
  * @param firstName
  * @param lastName
  * @param email
  * @param phone
  */
case class User(
    id: Option[Long],
    legalId: String,
    firstName: String,
    lastName: String,
    email: String,
    phone: String)