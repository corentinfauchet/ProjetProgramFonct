name := "projet-scala"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies += "com.lihaoyi" %% "requests" % "0.6.9"

libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "2.2.1"

libraryDependencies ++= Seq(

  "org.seleniumhq.webdriver" % "webdriver-htmlunit" % "0.9.7376"

)
