name := "social-network"
version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  guice,
  javaJpa,
  "org.apache.pekko" %% "pekko-actor-typed" % "1.0.1",
  "org.apache.pekko" %% "pekko-actor" % "1.0.1",
  "mysql" % "mysql-connector-java" % "8.0.33",
  "com.typesafe.play" %% "play-json" % "2.9.4",
  "org.hibernate" % "hibernate-core" % "6.4.1.Final",
  "org.hibernate.javax.persistence" % "hibernate-jpa-2.1-api" % "1.0.2.Final",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.0",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.13.0"
)

// Add dependency resolution rules
ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always"

// Force the latest version of Twirl API
dependencyOverrides += "org.playframework.twirl" %% "twirl-api" % "2.0.3"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._" 