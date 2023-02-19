import Dependencies._

ThisBuild / organization := "com.mobe"
ThisBuild / scalaVersion := "3.2.1"

ThisBuild / scalacOptions ++=
  Seq(
    "-deprecation",
    "-explain",
    "-feature",
    "-language:implicitConversions",
    "-Wunused:all",
    "-unchecked",
    "-Xfatal-warnings",
    "-Yexplicit-nulls", // experimental (I've seen it cause issues with circe)
    "-Ykind-projector",
    "-Ysafe-init", // experimental (I've seen it cause issues with circe)
  ) ++ Seq("-rewrite", "-indent") ++ Seq("-source", "future-migration")

lazy val `hacman-zio` =
  project
    .in(file("."))
    .settings(name := "hacman-zio")
    .settings(commonSettings)
    .settings(dependencies)

lazy val commonSettings = {
  lazy val commonScalacOptions = Seq(
    Compile / console / scalacOptions --= Seq(
      "-Wunused:_",
      "-Xfatal-warnings",
    ),
    Test / console / scalacOptions :=
      (Compile / console / scalacOptions).value,
  )

  lazy val otherCommonSettings = Seq(
    update / evictionWarningOptions := EvictionWarningOptions.empty
  )

  Seq(
    commonScalacOptions,
    otherCommonSettings,
  ).reduceLeft(_ ++ _)
}

lazy val dependencies = Seq(
  libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % "2.0.9",
    "dev.zio" %% "zio-http" % "0.0.4",
  ),
  libraryDependencies ++= Seq(
    "com.vladsch.flexmark" % "flexmark-all" % "0.64.0" % Test
  ),
  libraryDependencies ++= Seq(
    "dev.zio" %% "zio-test" % "2.0.9" % Test,
    "dev.zio" %% "zio-test-sbt" % "2.0.9" % Test,
    "dev.zio" %% "zio-test-magnolia" % "2.0.9" % Test
  ),
  libraryDependencies ++= Seq(
    com.eed3si9n.expecty,
    org.scalatest.scalatest,
    org.scalatestplus.`scalacheck-1-16`,
    org.scalameta.munit,
  ).map(_ % Test),
)

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

Test / publishArtifact := false
Test / parallelExecution := false

Test / testOptions ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-oSD"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

console / initialCommands  := "import com.mobe.collections.*"
