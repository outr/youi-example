package io.youi.example

import io.youi._
import io.youi.app.ClientApplication

import scala.scalajs.js.annotation.JSExportTopLevel

/**
  * The client application implementation. This requires two mix-ins:
  *   - ClientApplication: for client-side related functionality and initializing the browser functionality
  *   - ExampleApplication: defines this application as providing an implementation of ExampleApplication shared trait.
  */
object ClientExampleApplication extends ClientApplication with ExampleApplication {
  /**
    * Makes sure the HelloScreen is initialized so it can be checked for URL matching.
    */
  val hello = HelloScreen

  /**
    * This is the main entry-point into the Scala.js application. We export it as a top-level function in JavaScript to
    * allow it to be executed as `application()`. The only action we need to take in this method is to initialize the UI.
    */
  @JSExportTopLevel("application")
  def main(): Unit = ui.init()
}
