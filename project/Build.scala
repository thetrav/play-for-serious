import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "bootstrap"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "org.mockito" % "mockito-all" % "1.9.0"
  )

  def customLessEntryPoints(base: File): PathFinder = (
      (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
      (base / "app" / "assets" / "stylesheets" / "bootstrap" * "responsive.less") +++
      (base / "app" / "assets" / "stylesheets" * "*.less")
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    lessEntryPoints <<= baseDirectory(customLessEntryPoints)
  )

}
