package io.youi.example

import io.youi.{Color, Key, dom}
import io.youi.app.screen.{PathActivation, UIScreen}
import io.youi.component._
import io.youi.component.extras.HTMLComponent
import io.youi.layout.VerticalLayout
import io.youi.net._
import org.scalajs.dom.html.Input
import org.scalajs.dom.{Event, html}
import reactify._

import scala.concurrent.Future

class ChatScreen extends UIScreen with PathActivation {
  def communication: ExampleCommunication = ClientExampleApplication.communication.instances().head

  lazy val heading: HTMLTextView = new HTMLTextView() {
    value := "Chat Screen"
    font.size := 36.0
    color := Color.DarkBlue
    position.center := container.position.center
    position.top := 10.0
  }
  lazy val usernameLabel: HTMLTextView = new HTMLTextView {
    value := "Username: "
    font.size := 24.0
    color := Color.Black
    position.left := container.position.center - 450.0
    position.top := heading.position.bottom + 20.0
  }
  lazy val usernameValue: HTMLComponent[html.Input] = new HTMLComponent[html.Input] {
    override protected val element: Input = dom.create[html.Input]("input")
    override def componentType: String = "Input"

    element.addEventListener("change", (_: Event) => {
      communication.username := element.value
    })
    element.style.fontFamily = "sans-serif"
    element.style.fontSize = "24px"
    position.left := usernameLabel.position.right + 10.0
    position.middle := usernameLabel.position.middle
  }
  lazy val messageLabel: HTMLTextView = new HTMLTextView {
    value := "Message: "
    font.size := 24.0
    color := Color.Black
    position.left := usernameLabel.position.left
    position.top := usernameLabel.position.bottom + 10.0
  }
  lazy val messageInput: HTMLComponent[html.Input] = new HTMLComponent[html.Input] {
    override protected val element: Input = dom.create[html.Input]("input")
    override def componentType: String = "Input"

    element.style.fontFamily = "sans-serif"
    element.style.fontSize = "60px"
    element.size = 60
    position.left := messageLabel.position.right + 10.0
    position.middle := messageLabel.position.middle
    event.key.up.attach { evt =>
      if (evt.key == Key.Enter) {
        val value = element.value.trim
        if (value.nonEmpty) {
          communication.broadcast(value)
          element.value = ""
        }
      }
    }
  }
  lazy val messageHistory: TypedContainer[ChatMessage] = new TypedContainer[ChatMessage] {
    position.center := container.position.center
    position.top := messageLabel.position.bottom + 10.0
    size.width := 900.0
    size.height := container.size.height - messageLabel.position.bottom - 20.0
    background := Color.AliceBlue
//    border := Border(Stroke(Color.Black, lineWidth = 1.0), 5.0)
    layout := new VerticalLayout(10.0)
  }

  override def path: Path = path"/chat.html"

  override def createUI(): Future[Unit] = {
    container.children ++= Seq(
      heading, usernameLabel, usernameValue, messageLabel, messageInput, messageHistory
    )
    Future.successful(())
  }

  def showMessage(sender: String, message: String): Unit = {
    messageHistory.children += new ChatMessage(sender, message)
  }
}