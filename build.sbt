name := "LotsOfNames"
organization := "tech.navicore"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
scalacOptions ++= Seq(
  "-target:jvm-1.8"
)
fork := true
javaOptions in test ++= Seq(
  "-Xms512M",
  "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)

parallelExecution in test := false

crossScalaVersions := List("2.12.16", "2.13.8")
enablePlugins(GitVersioning)
ThisBuild / publishTo := sonatypePublishToBundle.value
inThisBuild(
  List(
    organization := "tech.navicore",
    homepage := Some(url("https://github.com/navicore/lots-of-names")),
    licenses := List(
      "MIT" -> url(
        "https://github.com/navicore/lots-of-names/blob/master/LICENSE"
      )
    ),
    developers := List(
      Developer(
        "navicore",
        "Ed Sweeney",
        "ed@onextent.com",
        url("https://navicore.tech")
      )
    )
  )
)

libraryDependencies ++=
  Seq(
    "org.scalatest" %% "scalatest" % "3.2.12" % "test"
  )

assemblyJarName in assembly := "LotsOfNames.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf")                      => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @_*)                     => MergeStrategy.discard
  case _                                               => MergeStrategy.first
}
