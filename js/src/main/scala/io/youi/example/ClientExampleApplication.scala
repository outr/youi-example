package io.youi.example

import io.youi.app.ClientApplication

import scala.scalajs.js.annotation.JSExportTopLevel

object ClientExampleApplication extends ExampleApplication with ClientApplication {
  val hello = HelloScreen

  @JSExportTopLevel("application")
  def main(): Unit = {
    scribe.info("client application started!")
  }
}
