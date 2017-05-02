package space.yangshuai.nod.tutorial.greedy

import Array._

/**
  * Created by rotciv on 2017/3/18.
  */
object Prim {

  def main(args: Array[String]): Unit = {

    val arr = scala.io.StdIn.readLine().split(" ")
    val N = arr(0).toInt
    val M = arr(1).toInt

    val matrix = ofDim[Int](N, N)

    val in = collection.mutable.HashSet[Int]()
    val out = collection.mutable.HashSet[Int]()

    for (i <- 1 until N) out += i
    in += 0

    for (_ <- 0 until M) {
      val values = scala.io.StdIn.readLine().split(" ")
      val start = values(0).toInt - 1
      val end = values(1).toInt - 1
      val weight = values(2).toInt
      matrix(start)(end) = weight
      matrix(end)(start) = weight
    }

    var sum = 0
    var min = Int.MaxValue
    var point = 0

    while (out.nonEmpty) {
      min = Int.MaxValue
      point = 0
      for (inPoint <- in) {
        for (outPoint <- out) {
          val weight = matrix(inPoint)(outPoint)
          if (weight > 0) {
            if (weight < min) {
              min = weight
              point = outPoint
            }
          }
        }
      }
      sum += min
      out.remove(point)
      in.add(point)
    }

    println(sum)
  }

}

