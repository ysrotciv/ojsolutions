package space.yangshuai.ojsolutions.nod.tutorial.dp

/**
  * Created by rotciv on 2017/4/18.
  */
object AssignInteger {

  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().toInt
    val numbers = new Array[Int](n)
    var sum = 0
    for (i <- 0 until n) {
      numbers(i) = scala.io.StdIn.readLine().toInt
      sum += numbers(i)
    }

    val matrix = Array.ofDim[Int](n + 1, sum / 2 + 1)

    for (i <- 0 to n) {
      for (j <- 0 to sum / 2) {
        if (i == 0) {
          matrix(i)(j) = 0
        } else if (j == 0) {
          matrix(i)(j) = 0
        } else {
          val number = numbers(i - 1)
          if (j >= number) {
            matrix(i)(j) = max(matrix(i - 1)(j), matrix(i - 1)(j - number) + number)
          } else {
            matrix(i)(j) = matrix(i - 1)(j)
          }
        }
      }
    }

    println(sum - matrix(n)(sum / 2) * 2)
  }

  def max(a: Int, b: Int): Int = {
    if (a > b) {
      a
    } else {
      b
    }
  }

}
