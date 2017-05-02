package space.yangshuai.nod.challenge.dp

/**
  * Created by rotciv on 2017/4/24.
  */
object Solution1009 {

  def main(args: Array[String]): Unit = {

    val n = scala.io.StdIn.readLine().toInt
    val length = n.toString.length

    var count = 0

    val bitCounts = new Array[Int](length)

    bitCounts(0) = 0
    var bitNum = 1

    for (i <- 1 until length) {
      bitCounts(i) = bitCounts(i - 1) * 10 + bitNum
      bitNum *= 10
    }

    var sum = 0

    var by = 1
    for (_ <- 0 until length - 1) {
      by *= 10
    }

    for (i <- 0 until length) {
      val ratio = n.toString.charAt(i) - '0'
      sum += ratio * bitCounts(length - i - 1)
      if (ratio > 1) {
        sum += by
      } else if (ratio == 1) {
        sum += n % by + 1
      }
      by /= 10
    }

    println(sum)

  }

}
