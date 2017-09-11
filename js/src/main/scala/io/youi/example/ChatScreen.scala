package io.youi.example

import io.youi.{Color, Key}
import io.youi.app.screen.{PathActivation, UIScreen}
import io.youi.component._
import io.youi.hypertext.TextInput
import io.youi.layout.VerticalLayout
import io.youi.paint.{Border, Stroke}
import reactify._

object ChatScreen extends UIScreen with PathActivation {
  def communication: ExampleCommunication = ClientExampleApplication.communication.instances().head

  lazy val title: BasicText = new BasicText {
    value := "Chat Screen"
    font.size := 36.0
    fill := Color.DarkBlue
    position.center := container.position.center
    position.top := 10.0
  }
  lazy val usernameLabel: BasicText = new BasicText {
    value := "Username: "
    font.size := 24.0
    fill := Color.Black
    position.left := container.position.center - 450.0
    position.top := title.position.bottom + 20.0
  }
  lazy val usernameValue: HTMLComponent[TextInput] = new HTMLComponent[TextInput](new TextInput) {
    communication.username.bind(component.value)
    component.font.family := "sans-serif"
    component.font.size := 24.0
    position.left := usernameLabel.position.right + 10.0
    position.middle := usernameLabel.position.middle
  }
  lazy val messageLabel: BasicText = new BasicText {
    value := "Message: "
    font.size := 24.0
    fill := Color.Black
    position.left := usernameLabel.position.left
    position.top := usernameLabel.position.bottom + 10.0
  }
  lazy val messageInput: HTMLComponent[TextInput] = new HTMLComponent[TextInput](new TextInput) {
    component.element.size = 60
    component.font.family := "sans-serif"
    component.font.size := 24.0
    position.left := messageLabel.position.right + 10.0
    position.middle := messageLabel.position.middle
    component.event.key.up.attach { evt =>
      if (evt.key == Key.Enter) {
        val value = component.value().trim
        if (value.nonEmpty) {
          communication.broadcast(value)
          component.value := ""
        }
      }
    }
  }
  lazy val messageHistory: TypedContainer[ChatMessage] = new TypedContainer[ChatMessage] with ScrollSupport {
    position.center := container.position.center
    position.top := messageLabel.position.bottom + 10.0
    size.width := 900.0
    size.height := container.size.height - messageLabel.position.bottom - 20.0
    background := Color.AliceBlue
    border := Border(Stroke(Color.Black, lineWidth = 1.0), 5.0)
    layoutManager := new VerticalLayout(10.0)
  }

  override def path: String = "/chat.html"

  override def createUI(): Unit = {
    container.children ++= Seq(
      title, usernameLabel, usernameValue, messageLabel, messageInput, messageHistory
    )
  }

  def showMessage(sender: String, message: String): Unit = {
    messageHistory.children += new ChatMessage(sender, message)
  }
}