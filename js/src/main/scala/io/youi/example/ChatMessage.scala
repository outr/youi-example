package io.youi.example

import io.youi.Color
import io.youi.component.{Container, HTMLTextView}
import reactify._

class ChatMessage(sender: String, message: String) extends Container {
  val senderLabel: HTMLTextView = new HTMLTextView() {
    value := s"[$sender]: "
    font.size := 18.0
    color := Color.DarkBlue
    position.left := 5.0
  }

  val messageText: HTMLTextView = new HTMLTextView() {
    value := message
    font.size := 16.0
    color := Color.Black
    position.left := senderLabel.position.right + 5.0
    position.middle := senderLabel.position.middle
  }

  children += senderLabel
  children += messageText
}
