package space.yangshuai.nod.tutorial.dp

/**
  * Created by rotciv on 2017/4/23.
  */
object BetterLIS {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val tailArr = new Array[Int](n)
    var next = 1
    for (i <- 0 until n) {
      val value = scala.io.StdIn.readLine().toInt
      if (i == 0) {
        tailArr(0) = value
      } else if (value < tailArr(0)) {
        tailArr(0) = value
      } else if (value > tailArr(next - 1)) {
        tailArr(next) = value
        next += 1
      } else {
        replace(0, next - 1, tailArr, value)
      }
    }

    println(next)
  }

  private def replace(left: Int, right: Int, arr: Array[Int], value: Int): Unit = {

    var l = left
    var r = right

    while (r - l > 1) {
      val m = l + (r - l) / 2
      if (arr(m) > value) {
        r = m
      } else {
        l = m
      }
    }
    arr(r) = value
  }

}
