package space.yangshuai.ojsolutions.nod.tutorial.greedy

import scala.collection.mutable

/**
  * Created on 2017/4/17.
  *
  * @author shuai.yang
  */
object Dijkstra {

  def main(args: Array[String]): Unit = {

    var arr = scala.io.StdIn.readLine().split(" ")
    val n = arr(0).toInt
    val m = arr(1).toInt
    val start = arr(2).toInt
    val end = arr(3).toInt

    var current = start

    val scores = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    if (m == 0) {
      println("0 " + scores(0))
      return
    }

    val scoreSum = new Array[Int](n)
    scoreSum(start) = scores(start)

    val pathMap = mutable.HashMap[Int, mutable.HashMap[Int, Int]]()

    for (_ <- 0 until m) {
      arr = scala.io.StdIn.readLine().split(" ")
      val head = arr(0).toInt
      val tail = arr(1).toInt
      val time = arr(2).toInt

      val headMap = pathMap.getOrElse(head, mutable.HashMap[Int, Int]())
      headMap.put(tail, time)
      pathMap.put(head, headMap)

      val tailMap = pathMap.getOrElse(tail, mutable.HashMap[Int, Int]())
      tailMap.put(head, time)
      pathMap.put(tail, tailMap)
    }

    val relationMap = mutable.Map[Int, Int]()
    val in = mutable.Set[Int]()
    in.add(start)

    val times = new Array[Int](n)
    for (i <- 0 until n) {
      if (i == start) {
        times(i) = 0
      } else {
        times(i) = Int.MaxValue
      }
    }

    while (true) {

      val timeMap = pathMap(current)
      var min = Int.MaxValue
      var score = 0
      var next = 0

      timeMap.foreach(kv => {
        if (!in.contains(kv._1)) {
          val time = kv._2
          // update times array
          if (times(current) + time < times(kv._1)) {
            scoreSum(kv._1) = scoreSum(current) + scores(kv._1)
            relationMap.put(kv._1, current)
            times(kv._1) = times(current) + time
          } else if (times(current) + time == times(kv._1)) {
            if (scoreSum(current) + scores(kv._1) > scoreSum(kv._1)) {
              scoreSum(kv._1) = scoreSum(current) + scores(kv._1)
              relationMap.put(kv._1, current)
            }
          }
        }
      })

      for (i <- 0 until n) {
        if (!in.contains(i)) {
          if (times(i) < min) {
            min = times(i)
            next = i
            score = scores(i)
          } else if (times(i) == min) {
            if ((scores(i) > score && next != end) || i == end) {
              next = i
              score = scores(i)
            }
          }
        }
      }

      if (next == end) {
        var sum = scores(next)
        while (relationMap.contains(next)) {
          next = relationMap(next)
          sum += scores(next)
        }
        println(times(end) + " " + sum)
        return
      } else {
        current = next
        in.add(current)
      }
    }
  }
}
