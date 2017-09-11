package io.youi.example

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * The server implementation of ExampleCommunication. Notice only the methods with @server annotation must be
  * implemented in this trait.
  */
trait ServerExampleCommunication extends ExampleCommunication { self =>
  username.static(generateUsername("Guest"))

  override def broadcast(message: String): Future[Unit] = {
    val futures = ServerExampleApplication.communication.instances().map { instance =>
      instance.showMessage(username(), message)
    }
    Future.sequence(futures).map(_ => ())
  }

  def generateUsername(default: String, increment: Int = 0): String = {
    val username = if (increment == 0) {
      default
    } else {
      s"$default ($increment)"
    }
    if (!usernames.contains(username)) {
      username
    } else {
      generateUsername(default, increment + 1)
    }
  }

  def usernames: Set[String] = ServerExampleApplication.communication.instances().map(_.username())
}