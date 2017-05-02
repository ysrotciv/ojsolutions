package space.yangshuai.nod.challenge.dp

/**
  * Created by rotciv on 2017/4/24.
  */
object Solution1002 {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val arr = new Array[Array[Int]](n)

    for (i <- 0 until n) {
      arr(i) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    }

    val matrix = Array.ofDim[Int](n, n)
    var result = Integer.MIN_VALUE

    for (i <- 0 until n) {
      for (j <- 0 to i) {
        if (i == 0) {
          matrix(i)(j) = arr(i)(j)
        } else if (j == 0) {
          matrix(i)(j) = matrix(i - 1)(j) + arr(i)(j)
        } else if (j == i) {
          matrix(i)(j) = matrix(i - 1)(j - 1) + arr(i)(j)
        } else {
          matrix(i)(j) = max(matrix(i - 1)(j - 1), matrix(i - 1)(j)) + arr(i)(j)
        }
        if (i == n - 1) {
          if (matrix(i)(j) > result) {
            result = matrix(i)(j)
          }
        }
      }
    }

    println(result)
  }

  def max(a: Int, b: Int): Int = {
    if (a > b) {
      a
    } else {
      b
    }
  }

}
