name := "LotsOfNames"
organization := "tech.navicore"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8") 
scalacOptions ++= Seq(
  "-target:jvm-1.8"
)
fork := true
javaOptions in test ++= Seq(
  "-Xms128M", "-Xmx256M",
  "-XX:+CMSClassUnloadingEnabled"
)

parallelExecution in test := false

version := "0.1.0"

val scala212 = "2.12.7"
val scala211 = "2.11.12"

crossScalaVersions := Seq(scala212, scala211)

publishMavenStyle := true

homepage := Some(url("https://github.com/navicore/lots-of-names"))

scmInfo := Some(ScmInfo(url("https://github.com/navicore/lots-of-names"),
                            "git@github.com:navicore/lots-of-names.git"))

developers := List(Developer("navicore",
                             "Ed Sweeney",
                             "ed@onextent.com",
                             url("https://github.com/navicore")))
licenses += ("MIT", url("https://opensource.org/licenses/MIT"))

import ReleaseTransformations._

releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value // Use publishSigned in publishArtifacts step

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts,
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)

credentials += Credentials(Path.userHome / ".sbt" / "pgp.credentials")  

// begin overwrite staging support
/* publishConfiguration := publishConfiguration.value.withOverwrite(true) */
/* com.typesafe.sbt.pgp.PgpKeys.publishSignedConfiguration := com.typesafe.sbt.pgp.PgpKeys.publishSignedConfiguration.value.withOverwrite(true) */
/* publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true) */
/* com.typesafe.sbt.pgp.PgpKeys.publishLocalSignedConfiguration := com.typesafe.sbt.pgp.PgpKeys.publishLocalSignedConfiguration.value.withOverwrite(true) */
// end overwrite staging support


sonatypeProfileName := "tech.navicore"
useGpg := true
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

libraryDependencies ++=
  Seq(

    "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  )

assemblyJarName in assembly := "LotsOfNames.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

