package io.youi.example

import io.youi.Color
import io.youi.component.{AbstractContainer, BasicText, Component}
import reactify._

class ChatMessage(sender: String, message: String) extends AbstractContainer {
  override type Child = Component

  val senderLabel: BasicText = new BasicText {
    value := s"[$sender]: "
    font.size := 18.0
    fill := Color.DarkBlue
    position.left := 5.0
  }

  val messageText: BasicText = new BasicText {
    value := message
    font.size := 16.0
    fill := Color.Black
    position.left := senderLabel.position.right + 5.0
    position.middle := senderLabel.position.middle
  }

  childEntries += senderLabel
  childEntries += messageText
}
