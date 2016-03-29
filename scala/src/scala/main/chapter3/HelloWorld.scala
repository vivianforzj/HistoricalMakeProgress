package scala.main.chapter3

import scala.util.Random

/**
 * Created by jzhou on 16-2-29.
 */
object HelloWorld {

  def main(args: Array[String]): Unit = {
//    println("Hello World")
  }

  def getArray(n: Int): Array[Int] = {
    val random = new Random(n);
    val intArray = new Array[Int](n);
    for (index <- 0 until n) {
      intArray(index) = random.nextInt(n)
    }
    intArray
  }
}
