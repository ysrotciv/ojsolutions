package space.yangshuai.ojsolutions.nod.tutorial.dp

/**
  * Created by rotciv on 2017/4/19.
  */
object MaxSubMatrix {

  def main(args: Array[String]): Unit = {

    val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val m = arr(0)
    val n = arr(1)

    val matrix = Array.ofDim[Int](n, m)

    for (i <- 0 until n) {
      val nums = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      for (j <- 0 until m) {
        matrix(i)(j) = nums(j)
      }
    }

    var max = 0

    for (i <- 0 until n) {
      val sums = new Array[Int](m)
      for (j <- i until n) {

        for (k <- 0 until m) {
          if (i == j) {
            sums(k) = matrix(i)(k)
          } else {
            sums(k) += matrix(j)(k)
          }
        }

        val result = maxSub(sums)
        if (result > max) {
          max = result
        }
      }
    }
    println(max)
  }

  private def maxSub(arr: Array[Int]): Int = {
    val sums = new Array[Int](arr.length)
    sums(0) = arr(0)
    var result = sums(0)
    for (i <- 1 until arr.length) {
      sums(i) = max(sums(i - 1), 0) + arr(i)
      if (sums(i) > result) {
        result = sums(i)
      }
    }
    result
  }

  def max(a: Int, b: Int): Int = {
    if (a > b) {
      a
    } else {
      b
    }
  }
}
