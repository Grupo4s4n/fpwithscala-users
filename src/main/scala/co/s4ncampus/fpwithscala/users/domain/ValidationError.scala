package co.s4ncampus.fpwithscala.users.domain

/**
  * Error management instance 
  */
sealed trait ValidationError extends Product with Serializable
case class UserAlreadyExistsError(user: User) extends ValidationError
case class UserDoesNotExistError(legalId: String) extends ValidationError