package space.yangshuai.ojsolutions.nod.tutorial.dp

/**
  * Created on 2017/4/18.
  *
  * @author shuai.yang
  */
object LongestIncreasingSubsequence {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val nums = new Array[Int](n + 1)
    nums(0) = Int.MinValue

    val lengths = new Array[Int](n + 1)
    lengths(0) = 0

    for (i <- 0 until n) {
      nums(i + 1) = scala.io.StdIn.readLine().toInt
    }

    var result = 0

    for (i <- 1 to n) {
      var maxLength = 0
      for (j <- 0 until i) {
        if (lengths(j) > maxLength && nums(i) > nums(j)) {
          maxLength = lengths(j)
        }
      }
      lengths(i) = maxLength + 1

      if (lengths(i) > result) {
        result = lengths(i)
      }
    }

    println(result)
  }

}
