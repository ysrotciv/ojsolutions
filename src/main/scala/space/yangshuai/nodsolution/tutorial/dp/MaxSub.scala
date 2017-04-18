package space.yangshuai.nodsolution.tutorial.dp

/**
  * Created by rotciv on 2017/4/17.
  */
object MaxSub {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val arr = new Array[Long](n)

    var maxSub = Long.MinValue

    for (i <- 0 until n) {
      arr(i) = scala.io.StdIn.readLine().toLong
      if (i > 0) {
        arr(i) = max(arr(i - 1), 0) + arr(i)
      }
      if (arr(i) > maxSub) {
        maxSub = arr(i)
      }
    }

    println(maxSub)
  }

  def max(a: Long, b: Long): Long = {
    if (a > b) {
      a
    } else {
      b
    }
  }

}
