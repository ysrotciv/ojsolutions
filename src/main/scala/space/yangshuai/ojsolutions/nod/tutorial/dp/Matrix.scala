package space.yangshuai.ojsolutions.nod.tutorial.dp

/**
  * Created by rotciv on 2017/4/17.
  */
object Matrix {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val matrix = Array.ofDim[Int](n, n)

    for (i <- 0 until n) {
      matrix(i) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    }

    for (i <- 0 until n) {
      for (j <- 0 until n) {
        if (i == 0) {
          if (j != 0) {
            matrix(i)(j) = matrix(i)(j - 1) + matrix(i)(j)
          }
        } else {
          if (j == 0) {
            matrix(i)(j) = matrix(i - 1)(j) + matrix(i)(j)
          } else {
            matrix(i)(j) = max(matrix(i - 1)(j), matrix(i)(j - 1)) + matrix(i)(j)
          }
        }
      }
    }

    println(matrix(n - 1)(n - 1))
  }

  private def max(one: Int, another: Int): Int = {
    if (one > another) {
      one
    } else {
      another
    }
  }
}
