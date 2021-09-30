package co.s4ncampus.fpwithscala.users.infraestructure.repository

import co.s4ncampus.fpwithscala.users.domain._

import cats.data._
import cats.syntax.all._
import doobie._
import doobie.implicits._
import cats.effect.Bracket


private object UserSQL {

  /**
    * Method in charge to execute the sql statement to insert an user in the database
    *
    * @param user
    * @return
    */
  def insert(user: User): Update0 = sql"""
    INSERT INTO USERS (LEGAL_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE)
    VALUES (${user.legalId}, ${user.firstName}, ${user.lastName}, ${user.email}, ${user.phone})
  """.update

  /**
    * Method in charge to execute the sql statement to find an user using the ilegalId
    *
    * @param legalId
    * @return
    */
  def selectByLegalId(legalId: String): Query0[User] = sql"""
    SELECT ID, LEGAL_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE
    FROM USERS
    WHERE LEGAL_ID = $legalId
  """.query[User]

  /**
    * Method in charge to execute the sql statement to delete an user using the legalId
    *
    * @param legalId
    * @return
    */
  def deleteByLegalID(legalId: String): Update0 = sql"""
  DELETE
  FROM USERS
  WHERE LEGAL_ID = $legalId
  """.update

  /**
    * Method in charge to execute the sql statement to update an user using hte legalId
    *
    * @param legalId
    * @param user
    * @return
    */
  def updateByLegalID(legalId:String, user:User): Update0 = sql"""
  UPDATE USERS SET  LEGAL_ID = ${legalId}, 
                    FIRST_NAME = ${user.firstName}, 
                    LAST_NAME = ${user.lastName}, 
                    EMAIL = ${user.email}, 
                    PHONE = ${user.phone}
      WHERE LEGAL_ID = ${legalId}
    """.update
}


/**
  * Class created to act as the persistence layer who communicates directly to the database
  *
  * @param xa
  * @param bracket$F$0
  * @tparam F
  */
class DoobieUserRepositoryInterpreter[F[_]: Bracket[?[_], Throwable]](val xa: Transactor[F])
    extends UserRepositoryAlgebra[F] {
  import UserSQL._

  def create(user: User): F[User] = 
    insert(user).withUniqueGeneratedKeys[Long]("ID").map(id => user.copy(id = id.some)).transact(xa)

  def findByLegalId(legalId: String): OptionT[F, User] = OptionT(selectByLegalId(legalId).option.transact(xa))

  def deleteById(legalId: String): F[Int] = deleteByLegalID(legalId).run.transact(xa)

  def updateById(legalId: String, user: User): F[Int] = updateByLegalID(legalId,user).run.transact(xa)
}

object DoobieUserRepositoryInterpreter {
  def apply[F[_]: Bracket[?[_], Throwable]](xa: Transactor[F]): DoobieUserRepositoryInterpreter[F] =
    new DoobieUserRepositoryInterpreter[F](xa)
}