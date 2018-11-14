package io.youi.example

import scala.concurrent.Future
import org.scalajs.dom._

/**
  * The client implementation of ExampleCommunication. Notice only the methods with @client annotation must be
  * implemented in this trait.
  */
trait ClientExampleCommunication extends ExampleCommunication {
  override def showMessage(sender: String, message: String): Future[Unit] = {
    ClientExampleApplication.chat.showMessage(sender, message)

    Future.successful(())
  }
}