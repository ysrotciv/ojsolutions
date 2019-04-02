package space.yangshuai.ojsolutions.nod.contest

/**
  * Created by rotciv on 2017/3/3.
  */
object SolutionA {

  def main(args: Array[String]): Unit = {

    val iterator = scala.io.Source.stdin.getLines()
    val n = iterator.next().toInt

    val list = new Array[Array[Int]](n)

    for (i <- 0 until n) {
      val arr = iterator.next().split(" ").map(_.toInt)
      list(0) = arr
    }

    val askTimes = iterator.next().toInt

    for (i <- 0 until askTimes) {
      val arr = iterator.next().split(" ")
      val s1 = list(arr(0).toInt)
      val s2 = list(arr(1).toInt)
      val k = arr(2).toInt
    }
  }

  private def optimalValue(arr: Array[Int]): Int = {

    val list = arr.toList

    if (!list.contains(1)) return 0




    0
  }

}
