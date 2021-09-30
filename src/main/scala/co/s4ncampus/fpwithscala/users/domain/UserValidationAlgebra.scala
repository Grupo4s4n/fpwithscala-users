package co.s4ncampus.fpwithscala.users.domain

import cats.data.EitherT
import cats.data.OptionT

trait UserValidationAlgebra[F[_]] {
  /* Fails with a UserAlreadyExistsError */
  def doesNotExist(user: User): EitherT[F, UserAlreadyExistsError, Unit]
  def doesNotExistById(legalId: String): OptionT[F,User]
}