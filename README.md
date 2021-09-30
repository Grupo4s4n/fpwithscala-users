# FPWITHSCALA-USERS_TEAM4
(https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

FPwithScala-Users is an application with REST architecture based on an user system which
allows to perform CRUD operations.
Scala-powered.

## Team members
- Mogollón Mendoza, Richard Leonardo - richardmogollon@seven4n.com
- Pardo Arias, Nicolas Eduardo - nicolaspardo@seven4n.com
- Román Patiño, José Alejandro - joseroman@seven4n.com
- Tunjo Serna, Guillermo Andres - guillermotunjo@seven4n.com

## APP Architecture
![Architecture](https://raw.githubusercontent.com/Grupo4s4n/fpwithscala-users/main/FP_Architecture.png)

## Data model
![DataModel](https://github.com/Grupo4s4n/fpwithscala-users/blob/main/MBD.jpeg)
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
- [Scala 2.13](https://www.scala-lang.org/) - Object-oriented and functional programming in one concise, high-level language.
- [Cats 2.2.0](https://github.com/typelevel/cats) - Library which provides abstractions for functional programming in the Scala programming language.
- [HTTP4S 0.21.16](https://http4s.org/) - Typeful, functional, streaming HTTP for Scala.
- [Circe 0.13.6](https://circe.github.io/circe/) - A JSON library for Scala powered by Cats.
- [Doobie 0.9.2](https://tpolecat.github.io/doobie/) - A pure functional JDBC layer for Scala and Cats.
- [Munit 0.7.2](https://scalameta.org/munit/) - Scala testing library with actionable errors and extensible APIs.
- [LogBack 1.2.3](http://logback.qos.ch/) - Reliable, Fast & Flexible logging framework.
- [MunitCatsEffect 0.13.0](https://github.com/typelevel/munit-cats-effect) - Provides the ability to write tests that return IO and SyncIO values without needing to call any unsafe methods
- [Flyway 7.2.0](https://flywaydb.org/) - Version control for  database.
