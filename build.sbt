name := "youi-example"
organization in ThisBuild := "io.youi"
version in ThisBuild := "1.0.0"
scalaVersion in ThisBuild := "2.12.2"
crossScalaVersions in ThisBuild := List("2.12.2", "2.11.11")
resolvers in ThisBuild += Resolver.sonatypeRepo("releases")
scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

val youiVersion = "0.4.7"
val scalacticVersion = "3.0.3"
val scalaTestVersion = "3.0.3"

lazy val root = crossProject.in(file("."))
  .settings(
    name := "youi-example",
    libraryDependencies ++= Seq(
      "io.youi" %%% "youi-app" % youiVersion,
      "org.scalactic" %%% "scalactic" % scalacticVersion,
      "org.scalatest" %%% "scalatest" % scalaTestVersion % "test"
    )
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "io.youi" %% "youi-server-undertow" % youiVersion
    )
  )
  .jsSettings(
//    artifactPath in Compile in fastOptJS := (baseDirectory.value / ".." / "jvm" / "src" / "main" / "resources" / "app" / "application-fastopt.js"),
//    artifactPath in Test in fastOptJS := (baseDirectory.value / ".." / "jvm" / "src" / "main" / "resources" / "app" / "application-fastopt.js"),
//    artifactPath in fullOptJS := (baseDirectory.value / ".." / "jvm" / "src" / "main" / "resources" / "app" / "application-opt.js"),
//    crossTarget in fastOptJS := baseDirectory.value / ".." / "jvm" / "src" / "main" / "resources" / "app",
//    crossTarget in fullOptJS := baseDirectory.value / ".." / "jvm" / "src" / "main" / "resources" / "app",
//    crossTarget in packageJSDependencies := baseDirectory.value / ".." / "jvm" / "src" / "main" / "resources" / "app",
    skip in packageJSDependencies := false
  )
  .enablePlugins(YouIPlugin)

lazy val rootJS = root.js
lazy val rootJVM = root.jvm
