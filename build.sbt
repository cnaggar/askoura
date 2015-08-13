import _root_.sbt.Keys._

organization := "com.askoura"

lazy val root = (project in file(".")).
  settings(
    name := "askoura",
    version := "1.0"
  )