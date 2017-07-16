package io.youi.example

import io.youi.app.{MatcherPage, ScalaJSConfig}
import io.youi.http._
import io.youi.net.URLMatcher

object ExamplePage extends MatcherPage {
  override protected def matcher: URLMatcher = combined.any(path.exact("/"), path.exact("/index.html"))

  override protected def resource(httpConnection: HttpConnection): Option[Content] = ???

  override protected def scalaJSConfig: Option[ScalaJSConfig] = ???
}
