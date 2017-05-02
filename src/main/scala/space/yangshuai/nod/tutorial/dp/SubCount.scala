package space.yangshuai.nod.tutorial.dp

/**
  * Created by rotciv on 2017/4/23.
  */
object SubCount {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    val have = new Array[Int](100001)
    val dp = new Array[Long](n + 1)
    dp(0) = 1l
    for (i <- 1 to n) {
      val value = scala.io.StdIn.readLine().toInt
      dp(i) = dp(i - 1) * 2
      if (have(value) > 0) {
        dp(i) -= dp(have(value) - 1)
        if (dp(i) <= 0) {
          dp(i) += 1000000007
        }
      }
      have(value) = i
      if (dp(i) > 1000000007) {
        dp(i) = dp(i) % 1000000007
      }
    }
    println((dp(n) - 1) % 1000000007)
  }

}
