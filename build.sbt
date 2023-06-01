name := "LotsOfNames"
organization := "tech.navicore"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
scalacOptions ++= Seq(
  "-target:jvm-1.8"
)
fork := true
test / javaOptions ++= Seq(
  "-Xms512M",
  "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)

test / parallelExecution := false

crossScalaVersions := List("2.12.17", "2.13.10")

ThisBuild / organization := "tech.navicore"
ThisBuild / homepage := Some(url("https://github.com/navicore/lots-of-names"))
ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/navicore/lots-of-names"),
    "scm:git@github.com:navicore/lots-of-names.git"
  )
)
ThisBuild / licenses := List(
  "MIT" -> url(
    "https://github.com/navicore/lots-of-names/blob/master/LICENSE"
  )
)
ThisBuild / developers := List(
  Developer(
    "navicore",
    "Ed Sweeney",
    "ed@onextent.com",
    url("https://navicore.tech")
  )
)

ThisBuild / publishTo := sonatypePublishToBundle.value

libraryDependencies ++=
  Seq(
    "org.scalatest" %% "scalatest" % "3.2.16" % "test"
  )

assemblyJarName in assembly := "LotsOfNames.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf")                      => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @_*)                     => MergeStrategy.discard
  case _                                               => MergeStrategy.first
}
