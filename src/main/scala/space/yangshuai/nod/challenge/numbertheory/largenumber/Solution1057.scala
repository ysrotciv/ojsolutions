package space.yangshuai.nod.challenge.numbertheory.largenumber

/**
  * Created by rotciv on 2017/5/1.
  */
object Solution1057 {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine().toInt
    var big = BigInt(1)
    var ans = "1"
    var temp = 1l
    val limit = Long.MaxValue / 10000
    for (i <- 2 to n) {
     /* if (temp < limit) {
        temp *= i
      } else {
        ans = multi(ans.toCharArray.reverse, temp.toString.toCharArray.reverse)
        temp = i
      }*/
      big = big.*(BigInt(i))
    }
    /*if (temp != 1) {
      ans = multi(ans.toCharArray.reverse, temp.toString.toCharArray.reverse)
    }
    println(ans)
    */
    println(big)
  }

  private def multi(a: Array[Char], b: Array[Char]): String = {

    val arr = new Array[Int](a.length + b.length)

    for (i <- b.indices) {
      val multiplied = b(i) - '0'
      var temp = 0
      for (j <- a.indices) {
        val multiplier = a(j) - '0'
        val value = multiplier * multiplied + temp + arr(i + j)
        arr(i + j) = value % 10
        temp = value / 10
      }
      arr(i + a.length) = temp
    }

    arr.reverse.dropWhile(_ == 0).mkString("")
  }

  private def factorial(n: Int): Long = {
    var ans = 1l
    for (i <- 2 to n) {
      ans *= i
    }
    ans
  }

}
