package io.youi.example
import scala.concurrent.Future

/**
  * The server implementation of ExampleCommunication. Notice only the methods with @server annotation must be
  * implemented in this trait.
  */
trait ServerExampleCommunication extends ExampleCommunication {
  override def reverse(value: String): Future[String] = Future.successful(value.reverse)
}
