package co.s4ncampus.fpwithscala.users.domain

import cats.data._
import cats.Monad

class UserService[F[_]](repository: UserRepositoryAlgebra[F], validation: UserValidationAlgebra[F]) {
  def create(user: User)(implicit M: Monad[F]): EitherT[F, UserAlreadyExistsError, User] =
    for {
      _ <- validation.doesNotExist(user)
      saved <- EitherT.liftF(repository.create(user))
    } yield saved

  def find(legalId: String)(implicit M: Monad[F]):OptionT[F, User] =
    for {      
      founded <- repository.findByLegalId(legalId)
    } yield founded

  def delete(legalId: String)(implicit M: Monad[F]): OptionT[F, Int] =
    for {
      deleted <- OptionT.liftF(repository.deleteById(legalId))
    } yield deleted

  def update(legalId: String,user: User)(implicit M: Monad[F]): OptionT[F, Int] = 
    for {
      updated <- OptionT.liftF(repository.updateById(legalId, user))
    } yield updated
}

object UserService{
  def apply[F[_]](
                 repositoryAlgebra: UserRepositoryAlgebra[F],
                 validationAlgebra: UserValidationAlgebra[F],
                 ): UserService[F] =
    new UserService[F](repositoryAlgebra, validationAlgebra)
}