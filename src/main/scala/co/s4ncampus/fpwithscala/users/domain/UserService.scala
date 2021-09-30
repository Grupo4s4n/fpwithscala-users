package co.s4ncampus.fpwithscala.users.domain

import cats.data._
import cats.Monad

/**
  * The UserService layer is in charge of communicating the controller layer and the repository
  * @param repository
  * @param validation
  * @tparam F
  */
class UserService[F[_]](repository: UserRepositoryAlgebra[F], validation: UserValidationAlgebra[F]) {
  /**
    * Create a new user into DB
    * @param user
    * @param M
    * @return
    */
  def create(user: User)(implicit M: Monad[F]): EitherT[F, UserAlreadyExistsError, User] =
    for {
      _ <- validation.doesNotExist(user)
      saved <- EitherT.liftF(repository.create(user))
    } yield saved

  /**
    * Find an user into DB
    * @param legalId
    * @param M
    * @return
    */
  def find(legalId: String)(implicit M: Monad[F]):OptionT[F, User] =
    for {      
      founded <- repository.findByLegalId(legalId)
    } yield founded

  /**
    * Delete an user into DB
    * @param legalId
    * @param M
    * @return
    */
  def delete(legalId: String)(implicit M: Monad[F]): OptionT[F, Int] =
    for {
      deleted <- OptionT.liftF(repository.deleteById(legalId))
    } yield deleted

  /**
    * Update the changes made to the user into DB
    * @param legalId
    * @param user
    * @param M
    * @return
    */
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