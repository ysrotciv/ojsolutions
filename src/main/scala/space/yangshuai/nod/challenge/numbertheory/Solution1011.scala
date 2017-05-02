package space.yangshuai.nod.challenge.numbertheory

/**
  * Created by rotciv on 2017/3/7.
  */
object Solution1011 {

  private def gcd(a: Int, b: Int): Int = {
    if (a < b) gcd(b, a)
    else if (b == 0) a
    else gcd(a % b, b)
  }

  def main(args: Array[String]): Unit = {

    val nums = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    println(gcd(nums(0), nums(1)))
  }
}
