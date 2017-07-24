package io.youi.example

import io.youi.communication.{Communication, client, server}

import scala.concurrent.Future

/**
  * Defines the interface shared between client and server. Methods defined with @client must be implemented in the
  * Scala.js code and @server must be defined on the JVM implementation. Methods are ignored if they don't return
  * `Future`.
  */
trait ExampleCommunication extends Communication {
  /**
    * Allows the server to display an alert in the browser.
    */
  @client def alert(message: String): Future[Unit]

  /**
    * Allows the client to ask the server to reverse a String. A relatively pointless operation for the server to handle,
    * but a simplified example of communication from client -> server -> client.
    */
  @server def reverse(value: String): Future[String]
}