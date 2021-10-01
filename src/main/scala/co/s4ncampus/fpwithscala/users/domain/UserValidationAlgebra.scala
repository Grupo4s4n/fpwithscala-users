package co.s4ncampus.fpwithscala.users.domain

import cats.data.EitherT
import cats.data.OptionT

trait UserValidationAlgebra[F[_]] {  
  /**
    * Fails with a UserAlreadyExistsError 
    *
    * @param user
    * @return
    */
  def doesNotExist(user: User): EitherT[F, UserAlreadyExistsError, Unit]

  /**
    * Fails when a user does not exist
    *
    * @param legalId
    * @return
    */
  def doesNotExistById(legalId: String): OptionT[F,User]
}