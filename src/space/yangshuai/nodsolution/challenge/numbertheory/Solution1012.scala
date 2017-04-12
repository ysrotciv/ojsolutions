package space.yangshuai.nodsolution.challenge.numbertheory

/**
  * Created by rotciv on 2017/3/8.
  */
object Solution1012 {

  def main(args: Array[String]): Unit = {
    println(Int.MaxValue)
    val arr = scala.io.StdIn.readLine().split(" ")
    println(lcm(arr(0).toLong, arr(1).toLong))
  }

  private def lcm(a: Long, b: Long): Long = {
    a * (b / gcd(a, b))
  }

  private def gcd(a: Long, b: Long): Long = {
    if (a < b) gcd(b, a)
    else if (b == 0) a
    else gcd(a % b, b)
  }

}
