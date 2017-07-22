package io.youi.example

import io.youi.app.ServerApplication
import io.youi.http._
import io.youi.server.handler.HttpHandler

object ServerExampleApplication extends ServerApplication with ExampleApplication {
  val home: HttpHandler = handler.matcher(
    combined.any(
      path.exact("/"),
      path.exact("/index.html")
    )
  ).page()
}