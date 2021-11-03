package com.hei.projet



import com.hei.projet.Main.{m, n}
import org.jsoup.Jsoup

import java.util

class FonctionProjet {

  val doc = Jsoup.connect("https://www.boursier.com/actions/historique/trade-desk-the-class-a-US88339J1051,US.html").get()
  val parseddiv = doc.select("table[class=table table--all-col-right table--no-margin table--no-auto]")

  import java.util

  val Date = new util.ArrayList[String]
  val Cloture = new util.ArrayList[Double]
  val Variation = new util.ArrayList[String]
  val Volume = new util.ArrayList[String]
  val Ouverture = new util.ArrayList[Double]
  val PlusHaut = new util.ArrayList[Double]
  val PlusBas = new util.ArrayList[Double]
  val Donnees = new util.ArrayList[String]


  val alltr = parseddiv.select("tr")

  var i: Int = 0
  while ( {
    i < alltr.size
  }) {
    val row = alltr.get(i)
    //System.out.println("row")
    val rowItems = row.select("td")
    var j: Int = 0
    while ( {
      j < rowItems.size
    }) {
      //System.out.println(rowItems.get(j).text)
      Donnees.add(rowItems.get(j).text)
      if (j == 0) {
        Date.add(Donnees.get(j))
      }
      if (j == 1) {
        Cloture.add(Donnees.get(j).replace(",",".").toDouble)
      }
      if (j == 2){
        Variation.add(Donnees.get(j))
      }
      if (j == 3){
        Volume.add(Donnees.get(j))
      }
      if (j == 4){
        Ouverture.add(Donnees.get(j).replace(",",".").toDouble)
      }
      if (j == 5){
        PlusHaut.add(Donnees.get(j).replace(",",".").toDouble)
      }
      if (j == 6){
        PlusBas.add(Donnees.get(j).replace(",",".").toDouble)
      }
      j += 1
    }
    Donnees.clear()
    i += 1

  }

  //System.out.println(Date)
  //System.out.println(Cloture)
  //System.out.println(Variation)
  //System.out.println(Volume)
  //System.out.println(Ouverture)
  //System.out.println(PlusHaut)
  //System.out.println(PlusBas)
  System.out.println("Fin de la recuperation des données")


  def Chandelier(o: Double, f: Double) : Int  = if (o < f) 0 else 1

  def fonctionChandelier( o1 : Double, c1 : Double, m1 : Double, o2 : Double, c2 : Double): Unit = {
    if (Chandelier(o1,c1)==0 & Chandelier(o2,c2)==1)
      if (c2>o1 & m1<o2) println("Il faut vendre!")
      else println("Pas besoin de vendre")
    else if (Chandelier(o1,c1)==1 & Chandelier(o2,c2)==0)
      if (c1>o1 & m1<c2) println("Il faut acheter!")
      else println("Pas besoin de vendre")
    else if ((Chandelier(o1,c1)==1 & Chandelier(o2,c2)==1) | (Chandelier(o1,c1)==0 & Chandelier(o2,c2)==0))
      println("Pas besoin de vendre")
  }

  fonctionChandelier(Ouverture.get(n), Cloture.get(n), PlusHaut.get(n), Ouverture.get(m), Cloture.get(m))
  System.out.println("Fin de la fonction chandelier")
}
