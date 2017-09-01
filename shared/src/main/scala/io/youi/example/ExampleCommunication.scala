package io.youi.example

import io.youi.communication.{Communication, client, server}
import reactify.Var

import scala.concurrent.Future

/**
  * Defines the interface shared between client and server. Methods defined with @client must be implemented in the
  * Scala.js code and @server must be defined on the JVM implementation. Methods are ignored if they don't return
  * `Future`.
  */
trait ExampleCommunication extends Communication {
  /**
    * Shared value that can be updated by either the client or server and is automatically synchronized.
    */
  val username: Var[String] = shared[String]("Anonymous")

  /**
    * Called by the client to the server to broadcast a message.
    *
    * @param message the message to post
    */
  @server def broadcast(message: String): Future[Unit]

  /**
    * Called by the server to request the client show a message from a specific user.
    *
    * @param sender the username of the sender
    * @param message the message to show
    */
  @client def showMessage(sender: String, message: String): Future[Unit]
}