name in ThisBuild := "youi-example"
organization in ThisBuild := "io.youi"
version in ThisBuild := "1.0.0"
scalaVersion in ThisBuild := "2.12.3"

lazy val example = crossApplication.in(file("."))
  .settings(
    youiVersion := "0.6.0-SNAPSHOT"
  )

lazy val exampleJS = example.js
lazy val exampleJVM = example.jvm