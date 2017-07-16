package io.youi.example

import io.youi.app.{CommunicationManager, YouIApplication}

trait ExampleApplication extends YouIApplication {
  val communication: CommunicationManager[ExampleCommunication] = connectivity.communication[ExampleCommunication]
}