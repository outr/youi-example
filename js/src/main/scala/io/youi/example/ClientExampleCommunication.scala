package io.youi.example

import scala.concurrent.Future
import org.scalajs.dom._

trait ClientExampleCommunication extends ExampleCommunication {
  override def alert(message: String): Future[Unit] = Future.successful {
    window.alert(message)
  }
}