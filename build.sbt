import sbt.Keys._

organization := "com.askoura"

lazy val root = (project in file(".")).
  settings(
    name := "askoura",
    version := "1.0",
    libraryDependencies ++= Seq(
      "junit" % "junit" % "4.11" % Test,
      "com.novocode" % "junit-interface" % "0.11" % "test->default"
    )
  )

