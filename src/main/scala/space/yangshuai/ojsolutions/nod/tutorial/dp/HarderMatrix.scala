package space.yangshuai.ojsolutions.nod.tutorial.dp

/**
  * Created by yang
  * Created on 22/04/2017.
  */
object HarderMatrix {

  def main(args: Array[String]): Unit = {

    val temp = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val m = temp(0)
    val n = temp(1)

    val scores = Array.ofDim[Int](n, m)

    for (i <- 0 until n) {
      scores(i) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    }

    val matrix = Array.ofDim[Int](m + n, m + 1, m + 1)

    for (i <- 0 until m + n) {
      val start = max(i - n + 1, 0)
      val end = min(i, m)
      for (j <- start to end) {
        for (k <- start to end) {
          if (i * j * k == 0) {
            matrix(i)(j)(k) = 0
          } else if (j == k) {
            matrix(i)(j)(k) =
              max(matrix(i - 1)(j)(k), matrix(i - 1)(j)(k - 1), matrix(i - 1)(j - 1)(k), matrix(i - 1)(j - 1)(k - 1)) +
              scores(i - j)(j - 1)
          } else {
            matrix(i)(j)(k) =
              max(matrix(i - 1)(j)(k), matrix(i - 1)(j)(k - 1), matrix(i - 1)(j - 1)(k), matrix(i - 1)(j - 1)(k - 1)) +
                scores(i - j)(j - 1) + scores(i - k)(k - 1)
          }
        }
      }
    }

    println(matrix(m + n - 1)(m)(m))
  }

  def max(a: Int, b: Int, c: Int, d: Int): Int = {
    max(max(a, b), max(c, d))
  }

  def max(a: Int, b: Int): Int = {
    if (a > b) {
      a
    } else {
      b
    }
  }

  def min(a: Int, b: Int): Int = {
    if (a > b) {
      b
    } else {
      a
    }
  }
}
