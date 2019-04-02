package space.yangshuai.ojsolutions.nod.contest.contest24

/**
  * Created by rotciv on 2017/4/28.
  */
object SolutionA {

  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().toInt - 1
    val arr = new Array[Int](n)


    if ((1 + n) * 3 % 2 == 1) {
      println(0)
    } else {
      val total = (1 + n) * 3 / 2
      arr(0) = total - n - 1
      arr(1) = 1
      for (i <- 2 until n) {
        arr(i) = total - (arr(i - 1) + n + 1 - i)
      }
      println((n to 1 by -1).mkString(" "))
      println(arr.mkString(" "))
    }
  }

}
