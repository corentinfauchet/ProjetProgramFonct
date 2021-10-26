package com.hei.projet



import org.jsoup.Jsoup

class ScraperDoc {

  val doc = Jsoup.connect("https://www.boursier.com/actions/historique/trade-desk-the-class-a-US88339J1051,US.html").get()
  val parseddiv = doc.select("table[class=table table--all-col-right table--no-margin table--no-auto]")

  import java.util

  //val Ligne = new util.ArrayList[String]

  val alltr = parseddiv.select("tr")
  var j = 0
  var i = 1
  while ( {
    i < alltr.size
  }) { //first row is the col names so skip it.
    val specifictr = alltr.get(i)
    val alltd = specifictr.select("td")

    System.out.println(alltd)

    //while ( {
      //j < alltd.size
    //}) {


      //Ligne.add(alltd.get(j).text())
    //}
    i += 1
  }
  System.out.println("Suite")





  System.out.println("Fin")

}
