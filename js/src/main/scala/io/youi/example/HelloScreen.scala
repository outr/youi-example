package io.youi.example

import io.youi.HistoryStateChange
import io.youi.app.screen.{Screen, URLActivation}
import io.youi.net.URL

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object HelloScreen extends Screen with URLActivation {
  override def isURLMatch(url: URL): Boolean = url.path.decoded match {
    case "/" | "/index.html" => true
    case _ => false
  }

  override def updateURL(current: URL): Option[HistoryStateChange] = None

  protected override def activate(): Future[Unit] = super.activate().map { _ =>
    scribe.info("Hello Screen activated!")
  }
}
