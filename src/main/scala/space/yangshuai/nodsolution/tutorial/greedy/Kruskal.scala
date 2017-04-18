package space.yangshuai.nodsolution.tutorial.greedy

import scala.collection.mutable

/**
  * Created on 2017/4/14.
  *
  * @author shuai.yang
  */
object Kruskal {

  def main(args: Array[String]): Unit = {

    val arr = scala.io.StdIn.readLine().split(" ")
    val N = arr(0).toInt
    val M = arr(1).toInt

    val in = collection.mutable.HashSet[Int]()
    val out = collection.mutable.HashSet[Int]()
    val queue = mutable.PriorityQueue[(Int, Int, Int)]()(Ordering.by((x: (Int, Int, Int)) => -x._3))


    for (i <- 1 to N) out += i

    for (_ <- 0 until M) {
      val values = scala.io.StdIn.readLine().split(" ")
      val start = values(0).toInt
      val end = values(1).toInt
      val weight = values(2).toInt
      queue.enqueue((start, end, weight))
    }

    var sum = 0L

    while (out.nonEmpty) {

      val (start, end, weight) = queue.dequeue()

      if (in.contains(start) && in.contains(end)) {
      } else {
        in.add(start)
        in.add(end)
        sum += weight
        out.remove(start)
        out.remove(end)
      }

    }

    println(sum)
  }

}
