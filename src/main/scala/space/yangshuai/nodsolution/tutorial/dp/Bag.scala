package space.yangshuai.nodsolution.tutorial.dp

import scala.collection.mutable

/**
  * Created by rotciv on 2017/4/18.
  */
object Bag {

  def main(args: Array[String]): Unit = {

    val arr = scala.io.StdIn.readLine().split(" ")
    val n = arr(0).toInt
    val m = arr(1).toInt

    val list = mutable.ListBuffer[(Int, Int)]()

    for (_ <- 0 until n) {
      val item = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      list.append((item(0), item(1)))
    }

    val prices = new Array[Int](m + 1)

    for (i <- 0 to n) {
      var item: (Int, Int) = null
      if (i > 0) {
        item = list(i - 1)
      }
      for (j <- m to 0 by -1) {
        if (i == 0) {
          prices(j) = 0
        } else {
          if (j >= item._1) {
            prices(j) = max(prices(j), prices(j - item._1) + item._2)
          }
          if (i == n && j == m) {
            println(prices(j))
            return
          }
        }
      }
    }
  }

  def max(a: Int, b: Int): Int = {
    if (a > b) {
      a
    } else {
      b
    }
  }

}
