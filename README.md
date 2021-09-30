# FPWITHSCALA-USERS_TEAM4
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

FPwithScala-Users it is an application with REST architecture based on an user system which
allows to perform CRUD operations.
Scala-powered.

## Team members
- Mogollón Mendoza, Richard Leonardo - richardmogollon@seven4n.com
- Pardo Arias, Nicolas Eduardo - nicolaspardo@seven4n.com
- Román Patiño, José Alejandro - joseroman@seven4n.com
- Tunjo Serna, Guillermo Andres - guillermotunjo@seven4n.com

## Features
#### Create

It is the method in charge of creating a new user on our DB-host 
**Web request type** = POST
> URL params
```
http://localhost:8000/users
```
> Body params
```
{
"legalId":"103", 
"firstName":"fname",
"lastName":"lname",
"email":"example@mail.com",
"phone":"3224554412"
}
```
#### Read

It is a method in charge of bring user information into DB-host and display it.
**Web request type** = GET
> URL params 
```
http://localhost:8000/users/${legalId}
```
#### Update

It is a method in charge of modifying the data of the desired user.
**Web request type** = PUT
> URL params 
```
http://localhost:8000/users/update/${legalId}
```
> Body params
```
{
"legalId":"103", 
"firstName":"fnameupdated",
"lastName":"lnameupdated",
"email":"example@mail.com",
"phone":"3224554412"
}
```

#### Delete

It is a method in charge of delete user information into DB-host.
**Web request type** = DELETE
> URL params
```
http://localhost:8000/users/delete/${legalId}
```
## Technologies and libraries
- [Scala 2.13](https://www.scala-lang.org/) - object-oriented and functional programming in one concise, high-level language.
- [Cats 2.2.0](https://github.com/typelevel/cats) - 
- [HTTP4S 0.21.16](https://http4s.org/)
- [Circe 0.13.6](https://circe.github.io/circe/)
- [Doobie 0.9.2](https://tpolecat.github.io/doobie/)
- [Munit 0.7.2](https://scalameta.org/munit/)
- [LogBack 1.2.3](http://logback.qos.ch/)
- [MunitCatsEffect 0.13.0](https://github.com/typelevel/munit-cats-effect)
- [Flyway 7.2.0](https://flywaydb.org/)
