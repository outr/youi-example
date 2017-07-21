package io.youi.example

import java.io.File

import io.youi.app.SinglePageApplication
import io.youi.http._
import io.youi.server.UndertowServer
import io.youi.server.handler.HttpHandler

object ServerExampleApplication extends UndertowServer with ExampleApplication with SinglePageApplication {
  val home: HttpHandler = handler.matcher(
    combined.any(
      path.exact("/"),
      path.exact("/index.html")
    )
  ).htmlPage()

  override protected def templateDirectory: File = new File(".")

  override protected def appJSContent: Content = Content.classPath("app/application-fastopt.js")

  override protected def appJSMethod: String = "application"
}