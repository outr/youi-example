package io.youi.example

import io.youi.communication.{Communication, client, server}

import scala.concurrent.Future

trait ExampleCommunication extends Communication {
  @client def alert(message: String): Future[Unit]
  @server def reverse(value: String): Future[String]
}