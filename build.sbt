name := "youi-example"
organization in ThisBuild := "io.youi"
version in ThisBuild := "1.0.0"
scalaVersion in ThisBuild := "2.12.2"
crossScalaVersions in ThisBuild := List("2.12.2", "2.11.11")
resolvers in ThisBuild += Resolver.sonatypeRepo("releases")
scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

val scalacticVersion = "3.0.3"
val scalaTestVersion = "3.0.3"

lazy val example = crossApplication.in(file("."))
  .settings(
    name := "youi-example",
    youiVersion := "0.4.9",
    libraryDependencies ++= Seq(
      "org.scalactic" %%% "scalactic" % scalacticVersion,
      "org.scalatest" %%% "scalatest" % scalaTestVersion % "test"
    )
  )

lazy val exampleJS = example.js
lazy val exampleJVM = example.jvm