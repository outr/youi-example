package io.youi.example

import io.youi._
import io.youi.app.screen.{UIScreen, URLActivation}
import io.youi.component.BasicText
import io.youi.net.{URL, URLMatcher}

/**
  * HelloScreen is an example of a simple screen leveraging the canvas-based UI functionality. Though there are many
  * ways to handle content in YouI, the canvas-based functionality is the most powerful, and ultimately the preferred
  * mechanism if possible. We can mix-in UIScreen to simplify using canvas-based functionality and setting up the
  * default `Renderer`. Additionally, we mix-in URLActivation to match to "/" and "/index.html" for this Screen.
  */
object HelloScreen extends UIScreen with URLActivation {
  /**
    * This defines what URLs will match to this screen. Any matching URL will activate this screen automatically.
    *
    * Note: Screens have single-page application functionality built-in, although they can be used in more classic
    * scenarios as well.
    */
  override lazy val matcher: URLMatcher = http.combined.any(
    http.path.exact("/"),
    http.path.exact("/index.html")
  )

  /**
    * Handles updating the URL if the URL should need to be re-written during activation.
    */
  override def updateURL(current: URL): Option[HistoryStateChange] = None

  /**
    * This method is invoked after the Renderer and configured and the screen loaded in order to do the final
    * setup of the screen.
    */
  override def createUI(): Unit = {
    // Create a basic text element to render on the screen
    val text = new BasicText {
      value := "Hello, World!"
      font.size := 48.0
      fill := Color.DarkBlue

      // Because we are using Reactify, we can define complex functionality in our assignments.
      // However, in this case this will simply keep this text centered in the renderer no matter whether
      // the text changes, the screen resizes, the renderer moves, etc.
      position.center := ui.position.center
      position.middle := ui.position.middle
    }
    // We must add it to the container for it to display on this screen
    container.children += text
  }
}
