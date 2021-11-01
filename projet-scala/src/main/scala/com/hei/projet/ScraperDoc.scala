package com.hei.projet



import org.jsoup.Jsoup

import java.util

class ScraperDoc {

  val doc = Jsoup.connect("https://www.boursier.com/actions/historique/trade-desk-the-class-a-US88339J1051,US.html").get()
  val parseddiv = doc.select("table[class=table table--all-col-right table--no-margin table--no-auto]")

  import java.util

  val Date = new util.ArrayList[String]
  val Cloture = new util.ArrayList[String]
  val Variation = new util.ArrayList[String]
  val Volume = new util.ArrayList[String]
  val Ouverture = new util.ArrayList[String]
  val PlusHaut = new util.ArrayList[String]
  val PlusBas = new util.ArrayList[String]
  val Donnees = new util.ArrayList[String]


  val alltr = parseddiv.select("tr")

  System.out.println(alltr)

  var i: Int = 0
  while ( {
    i < alltr.size
  }) {
    val row = alltr.get(i)
    System.out.println("row")
    val rowItems = row.select("td")
    var j: Int = 0
    while ( {
      j < rowItems.size
    }) {
      System.out.println(rowItems.get(j).text)
      Donnees.add(rowItems.get(j).text)
      if (j == 0) {
        Date.add(Donnees.get(j))
      }
      if (j == 1) {
        Cloture.add(Donnees.get(j))
      }
      if (j == 2){
        Variation.add(Donnees.get(j))
      }
      if (j == 3){
        Volume.add(Donnees.get(j))
      }
      if (j == 4){
        Ouverture.add(Donnees.get(j))
      }
      if (j == 5){
        PlusHaut.add(Donnees.get(j))
      }
      if (j == 6){
        PlusBas.add(Donnees.get(j))
      }
      System.out.println(Date)
      //if (j != rowItems.size - 1) {
        //Donnees.add(",")
      //}

      j += 1
    }
    Donnees.clear()
    i += 1

  }

System.out.println(Date)
  System.out.println(Cloture)
  System.out.println(Variation)
  System.out.println(Volume)
  System.out.println(Ouverture)
  System.out.println(PlusHaut)
  System.out.println(PlusBas)



  System.out.println("Fin")

}
