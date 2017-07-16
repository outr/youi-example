package io.youi.example

import java.io.File

import io.youi.app.SinglePageApplication
import io.youi.http.Content
import io.youi.server.UndertowServer

object ServerExampleApplication extends UndertowServer with ExampleApplication with SinglePageApplication {
  val examplePage =

  override protected def templateDirectory: File = ???

  override protected def appJSContent: Content = ???

  override protected def appJSMethod: String = ???
}