package space.yangshuai.nod.challenge.dp

import scala.collection.mutable

/**
  * Created by rotciv on 2017/4/25.
  */
object Solution1021 {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val list = mutable.ListBuffer[Int]()

    var sum = 0

    for (_ <- 0 until n) {
      list.append(scala.io.StdIn.readLine().toInt)
    }

    for (_ <- 1 until n) {
      var min = Int.MaxValue
      var minIndex = 0

      for (i <- 0 until list.size - 1) {
        if (list(i) + list(i + 1) < min) {
          min = list(i) + list(i + 1)
          minIndex = i
        }
      }
      sum += min
      list(minIndex) = min
      list.remove(minIndex + 1)
    }

    println(sum)
  }

}
