package co.s4ncampus.fpwithscala.users.domain

import cats.Applicative
import cats.data.EitherT
import cats.data.OptionT
//### Logic releated with validation error ###
/**
  * @param repository
  */
class UserValidationInterpreter[F[_]: Applicative](repository: UserRepositoryAlgebra[F])
    extends UserValidationAlgebra[F] {
/**
  * @param user
  * @return
  */
  def doesNotExist(user: User): EitherT[F, UserAlreadyExistsError, Unit] = 
    repository.findByLegalId(user.legalId).map(UserAlreadyExistsError).toLeft(())

  /**
    * @param legalId
    * @return
    */
  def doesNotExistById(legalId: String): OptionT[F,User] = 
    repository.findByLegalId(legalId)
}

object UserValidationInterpreter {
  def apply[F[_]: Applicative](repository: UserRepositoryAlgebra[F]) =
    new UserValidationInterpreter[F](repository)
}