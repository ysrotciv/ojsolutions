package space.yangshuai.nodsolution.tutorial.greedy

import scala.collection.mutable

/**
  * Created by rotciv on 2017/4/15.
  */
object Kruskal {

  def main(args: Array[String]): Unit = {

    val arr = scala.io.StdIn.readLine().split(" ")
    val N = arr(0).toInt
    val M = arr(1).toInt

    val in = collection.mutable.HashSet[Int]()
    val out = collection.mutable.HashSet[Int]()
    val s = collection.mutable.HashMap[Int, collection.mutable.HashSet[(Int, Int)]]()
    val queue = mutable.PriorityQueue[(Int, Int)]()(Ordering.by((x: (Int, Int)) => -x._2))


    for (i <- 2 to N) out += i
    in += 1

    for (_ <- 0 until M) {
      val values = scala.io.StdIn.readLine().split(" ")
      val start = values(0).toInt
      val end = values(1).toInt
      val weight = values(2).toInt
      val startSet = s.getOrElse(start, new mutable.HashSet[(Int, Int)]())
      startSet.add(end, weight)
      val endSet = s.getOrElse(end, new mutable.HashSet[(Int, Int)]())
      endSet.add(start, weight)
      s.put(start, startSet)
      s.put(end, endSet)
    }

    var sum = 0L

    for (t <- s(1)) {
      queue.enqueue(t)
    }

    while (out.nonEmpty) {

      var newTuple = queue.dequeue()
      while (in.contains(newTuple._1)) {
        newTuple = queue.dequeue()
      }

      for (t <- s(newTuple._1)) {
        if (!in.contains(t._1)) {
          queue.enqueue(t)
        }
      }

      sum += newTuple._2
      out.remove(newTuple._1)
      in.add(newTuple._1)
    }

    println(sum)
  }

}
