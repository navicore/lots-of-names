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

crossScalaVersions := List("2.12.14", "2.13.6")

inThisBuild(List(
  organization := "tech.navicore",
  homepage := Some(url("https://github.com/navicore/lots-of-names")),
  licenses := List("MIT" -> url("https://github.com/navicore/lots-of-names/blob/master/LICENSE")),
  developers := List(
    Developer(
      "navicore",
      "Ed Sweeney",
      "ed@onextent.com",
      url("https://navicore.tech")
    )
  )
))

libraryDependencies ++=
  Seq(
    "org.scalatest" %% "scalatest" % "3.2.9" % "test"
  )

assemblyJarName in assembly := "LotsOfNames.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

