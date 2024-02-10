ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

val zioVersion = "2.0.13"

lazy val sharedSettings = Seq(
  libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % zioVersion,
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test,

  )
)

lazy val root = (project in file("."))
  .settings(
    name := "zio-init"
  )



lazy val `deep-zio` = project
  .settings(sharedSettings)
  .settings(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-json" % "0.5.0",
      "com.softwaremill.sttp.client3" %% "core" % "3.9.3",
      "org.jsoup" % "jsoup" % "1.16.1" % "provided",
    )
  )