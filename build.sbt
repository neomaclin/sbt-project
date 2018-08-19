name := "sbt-project"

version := "1.0"

scalaVersion := "2.12.4"

libraryDependencies ++= cats ++ validation ++ akka ++ di ++ http

lazy val http = {
  val akkaHttpVersion = "10.1.1"
  Seq(
    "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion,
    "de.heikoseeberger" %% "akka-http-circe"      % "1.21.0"
  )
}

lazy val cats = {
  val catsVersion  = "1.2.0"
  val circeVersion = "0.9.3"

  Seq(
    "org.typelevel" %% "cats-core",
    "org.typelevel" %% "cats-free"
  ).map(_ % catsVersion) ++
    Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser",
      "io.circe" %% "circe-java8"
    ).map(_ % circeVersion)
}

lazy val validation = {
  Seq(
    "org.scalacheck" %% "scalacheck"                  % "1.13.4",
    "org.scalatest"  %% "scalatest"                   % "3.0.1",
    "org.scalamock"  %% "scalamock-scalatest-support" % "3.5.0"
  ).map(_ % Test)
}

lazy val akka = {
  val akkaVersion = "2.5.11"
  Seq(
    "com.typesafe.akka"   %% "akka-actor"              % akkaVersion,
    "com.typesafe.akka"   %% "akka-stream"             % akkaVersion,
    "com.typesafe.akka"   %% "akka-cluster-sharding"   % akkaVersion,
    "com.typesafe.akka"   %% "akka-persistence"        % akkaVersion excludeAll (ExclusionRule("io.netty")),
    "com.typesafe.akka"   %% "akka-persistence-query"  % akkaVersion,
    "com.typesafe.akka"   %% "akka-distributed-data"   % akkaVersion,
    "com.typesafe.akka"   %% "akka-multi-node-testkit" % akkaVersion,
    "com.typesafe.akka"   %% "akka-testkit"            % akkaVersion % Test,
    "com.typesafe.akka"   %% "akka-stream-testkit"     % akkaVersion % Test,
    "com.twitter"         %% "chill-akka"              % "0.9.2",
    "com.google.protobuf" % "protobuf-java"            % "2.5.0"
  )
}

lazy val di = {
  val macwireVersion = "2.3.1"
  Seq(
    "com.softwaremill.macwire" %% "macros"     % macwireVersion % "provided",
    "com.softwaremill.macwire" %% "macrosakka" % macwireVersion % "provided",
    "com.softwaremill.macwire" %% "util"       % macwireVersion,
    "com.softwaremill.macwire" %% "proxy"      % macwireVersion
  )
}
