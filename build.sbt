scalaVersion := "3.3.1"
Test / fork := true

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client3" %% "core" % "3.10.1",
  "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % "3.10.1",
  "org.scala-lang.modules" %% "scala-xml" % "2.3.0",
  "dev.zio" %% "zio" % "2.1.1",
  "dev.zio" %% "zio-streams" % "2.1.13",
  "dev.zio" %% "zio-json" % "0.6.2",
  "dev.zio" %% "zio-http" % "3.0.0-RC8",
  "io.getquill" %% "quill-zio" % "4.7.0",
  "io.getquill" %% "quill-jdbc-zio" % "4.7.0",
  "com.h2database" % "h2" % "2.2.224",
  "dev.zio" %% "zio-test" % "2.1.0" % Test,
  "dev.zio" %% "zio-http-testkit" % "3.0.0-RC8" % Test,
  "dev.zio" %% "zio-test-sbt" % "2.1.1" % Test
)

resolvers ++= Resolver.sonatypeOssRepos("snapshots")
