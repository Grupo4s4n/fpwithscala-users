package co.s4ncampus.fpwithscala.users.domain

import cats.data.OptionT

/**
  * Abstraction layer between the data access layer and the business logic 
  */
trait UserRepositoryAlgebra[F[_]] {
  /**
    * Create user
    *
    * @param user
    * @return F[User]
    */
  def create(user: User): F[User]

  /**
    * Find an user by legalID
    *
    * @param legalId
    * @return F[Int]
    */
  def findByLegalId(legalId: String): OptionT[F, User]

  /**
    * Delete an user by legalID
    *
    * @param legalId
    * @return F[Int]
    */
  def deleteById(legalId: String): F[Int]

  /**
    * Update the data of an user by his ID
    *
    * @param legalId
    * @param user
    * @return F[Int]
    */
  def updateById(legalId: String, user:User): F[Int]
}