package space.yangshuai.nodsolution.challenge.greedy

import scala.collection.mutable

/**
  * Created by rotciv on 2017/4/26.
  */
object Solution1163 {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val indexQueue = mutable.PriorityQueue[(Int, Long)]()(Ordering.by(-_._1))
    val scoreQueue = mutable.PriorityQueue[(Int, Long)]()(Ordering.by(-_._2))

    for (_ <- 0 until n) {
      val values = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      indexQueue.enqueue((values(0), values(1)))
    }

    while (indexQueue.nonEmpty) {
      val pair = indexQueue.dequeue()
      scoreQueue.enqueue(pair)
      if (scoreQueue.size > pair._1) {
        scoreQueue.dequeue()
      }
    }

    println(scoreQueue.map(_._2).sum)
  }

}
