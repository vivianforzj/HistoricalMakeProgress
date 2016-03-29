package scala.main.chapter4

import java.io.File
import java.util.{Calendar, Scanner}
import scala.collection.JavaConversions.propertiesAsScalaMap

import scala.collection.{SortedMap, mutable}


/**
 * Created by jzhou on 16-3-10.
 */
object MapTest {

  def main (args: Array[String]): Unit ={
//    changePrice
//    countFrequency("test.txt")
//    countFrequencyImmutable("test.txt")
//    countFrequencySorted("test.txt")
//    testLinkedHatshMap()
//    printTable()
//    println(minmax(Array(1,6,4,8,2)))
//    println(lteqgt(Array(1,6,4,8,2), 3))
    lalian("Hello", "WorldY")
  }

  def countFrequency(file: String): Unit = {
    val reader = new Scanner(new File(file))
    val wordCountMap = new mutable.HashMap[String, Int]()
    while (reader.hasNext()) {
      val word = reader.next()

      wordCountMap(word) = wordCountMap.getOrElse(word, 0) + 1
    }

    for ((k,v) <- wordCountMap)
      println(k + ": " + v)
  }

  def countFrequencySorted(file: String): Unit = {
    val reader = new Scanner(new File(file))
    var wordCountMap = SortedMap[String, Int]()
    while (reader.hasNext()) {
      val word = reader.next()

      wordCountMap += (word -> (wordCountMap.getOrElse(word, 0) + 1))
    }

    println(wordCountMap.mkString(","))
  }

  def countFrequencyImmutable(file: String): Unit = {
    val reader = new Scanner(new File(file))
    var wordCountMap = Map[String, Int]()
    while (reader.hasNext()) {
      val word = reader.next()

      wordCountMap += (word -> (wordCountMap.getOrElse(word, 0) + 1))
    }

    for ((k,v) <- wordCountMap)
      println(k + ": " + v)
  }

  def changePrice: Unit = {
    val instrumentPriceMap = Map("Guitar" -> 2000, "Piano" -> 10000)
    val newMap = for ((k,v) <- instrumentPriceMap) yield (k, v * 0.9)
    printf(newMap.toString)
  }

  def testLinkedHashMap(): Unit = {
    var map = new mutable.LinkedHashMap[String, Int]

    map += ("Monday" -> Calendar.MONDAY, "Tuesday" -> Calendar.TUESDAY)

    println(map.mkString(","))
  }

  def printTable(): Unit = {
    val properties: scala.collection.Map[String, String] = System.getProperties()

    val keyLengths = for (k <- properties.keySet) yield k.length
    val max = keyLengths.max

    for ((k, v) <- properties) {
      print(k)
      print(" " * (max - k.length))
      print("|")
      println(v)
    }
  }

  def minmax(values: Array[Int]) = {
    val min = values.min
    val max = values.max
    (min, max)
  }

  def lteqgt(values: Array[Int], v: Int) = {
    val lt = values.count(_ < v)
    val eq = values.count(_ == v)
    val gt = values.count(_ > v)

    (lt, eq, gt)
  }

  def lalian(str1: String, str2: String) = {
    val res = str1.zip(str2)
    println(res.mkString(","))
  }
}
