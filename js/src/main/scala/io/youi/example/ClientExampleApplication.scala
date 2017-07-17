package io.youi.example

import io.youi.Cache
import io.youi.app.ClientApplication
import io.youi.net.URL

import scala.scalajs.js.annotation.JSExportTopLevel

object ClientExampleApplication extends ExampleApplication with ClientApplication {
  val hello = HelloScreen

  override def cached(url: URL): String = Cache.cached(url)

  @JSExportTopLevel("application")
  def main(): Unit = {
    scribe.info("client application started!")
  }
}
