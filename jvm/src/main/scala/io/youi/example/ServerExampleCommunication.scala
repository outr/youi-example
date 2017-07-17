package io.youi.example
import scala.concurrent.Future

trait ServerExampleCommunication extends ExampleCommunication {
  override def reverse(value: String): Future[String] = Future.successful(value.reverse)
}
