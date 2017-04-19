package space.yangshuai.nodsolution.tutorial.dp

/**
  * Created by rotciv on 2017/4/19.
  */
object MaxLoopSub {

  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().toInt
    val arr = new Array[Int](n)
    var sum = 0l

    for (i <- 0 until n) {
      arr(i) = scala.io.StdIn.readLine().toInt
      sum += arr(i)
    }

    val maxValue = maxSub(arr)
    val minValue = maxSub(arr.map(_ * -1)) * -1

    println(max(maxValue, sum - minValue))
  }

  private def maxSub(arr: Array[Int]): Long = {
    val sums = new Array[Long](arr.length)
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

  def max(a: Long, b: Long): Long = {
    if (a > b) {
      a
    } else {
      b
    }
  }

}
