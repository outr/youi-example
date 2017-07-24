package io.youi.example

import io.youi.app.{CommunicationManager, YouIApplication}

/**
  * Shared definition of the application. This is used to define the interface between client and server. Primarily
  * useful for defining communication end-points.
  */
trait ExampleApplication extends YouIApplication {
  /**
    * Defines a CommunicationManager for ExampleCommunication. This manages connectivity on both client and server to
    * allow communications from client -> server and server -> client via WebSocket.
    */
  val communication: CommunicationManager[ExampleCommunication] = connectivity.communication[ExampleCommunication]
}