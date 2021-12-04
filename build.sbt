import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val Question1And2 = (project in file("Question1And2"))
  .settings(
    name := "UT-IT-LEARNING",
      libraryDependencies += "org.scalatest"%%"scalatest"%"3.2.10"% Test
  )

lazy val Question3 = (project in file("Question3"))
  .settings(
    name := "UT-IT-LEARNING",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.10" % "test",
      "org.mockito" %% "mockito-scala-scalatest" % "1.16.46" % "test"
    )
  )
