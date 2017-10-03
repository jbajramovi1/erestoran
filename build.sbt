name := """eRestoran"""
organization := "abh"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies+=guice
libraryDependencies+=jdbc
libraryDependencies += evolutions
libraryDependencies += javaForms
libraryDependencies += filters
libraryDependencies ++= Seq(evolutions, jdbc)
libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.postgresql" % "postgresql" % "9.4.1208.jre7",
  cache,
  "org.mindrot" % "jbcrypt" % "0.3m",
  javaWs
)

resolvers ++= Seq(
    "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/"
)

resolvers += "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/"
fork in run := false