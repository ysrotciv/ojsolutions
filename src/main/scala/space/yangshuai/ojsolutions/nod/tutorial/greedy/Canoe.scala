package space.yangshuai.ojsolutions.nod.tutorial.greedy

import scala.collection.mutable.ListBuffer

/**
  * Created by rotciv on 2017/3/18.
  */
object Canoe {

  def main(args: Array[String]): Unit = {
    val arr = scala.io.StdIn.readLine().split(" ")
    val number = arr(0).toInt
    val limit = arr(1).toInt
    var count = 0

    var weights = new ListBuffer[Long]

    for (_ <- 0 until number) {
      val weight = scala.io.StdIn.readLine().toLong
      weights += weight
    }

    weights = weights.sorted

    while (weights.size > 1) {
      if (weights.last + weights.head <= limit) {
        weights.remove(0)
      }
      weights.remove(weights.size - 1)
      count += 1
    }

    if (weights.nonEmpty) count += 1

    println(count)
  }

}
