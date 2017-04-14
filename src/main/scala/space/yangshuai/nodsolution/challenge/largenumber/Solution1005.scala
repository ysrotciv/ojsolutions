package space.yangshuai.nodsolution.challenge.largenumber

/**
  * Created by rotciv on 2017/3/7.
  */
object Solution1005 {

  def main(args: Array[String]): Unit = {

    val first = scala.io.StdIn.readLine()
    val second = scala.io.StdIn.readLine()
    var result = ""

    if (!first.startsWith("-") && !second.startsWith("-")) {
      result = add(first, second)
    } else if (first.startsWith("-") && second.startsWith("-")) {
      result = "-" + add(first.substring(1), second.substring(1))
    } else if (first.startsWith("-")) {
      if (compare(first.substring(1), second) > 0) {
        result = "-" + subtract(first.substring(1), second)
      } else {
        result = subtract(second, first.substring(1))
      }
    } else {
      if (compare(first, second.substring(1)) > 0) {
        result = subtract(first, second.substring(1))
      } else {
        result = "-" + subtract(second.substring(1), first)
      }
    }

    if (result.equals("-") || result.isEmpty) result = "0"
    println(result)
  }

  def max(a: Int, b: Int): Int = {
    if (a > b) a
    else b
  }

  private def compare(a: String, b: String): Int = {
    if (a.length > b.length) return 1
    if (a.length == b.length) return a.compareTo(b)
    -1
  }

  private def add(a: String, b: String): String = {
    val first = a.reverse.toCharArray.map(_ - '0')
    val second = b.reverse.toCharArray.map(_ - '0')

    val length = max(first.length, second.length) + 1

    val arr = new Array[Int](length)

    var temp = 0

    for (i <- 0 until arr.length - 1) {
      var f = 0
      if (i < first.length) f = first(i)
      var s = 0
      if (i < second.length) s = second(i)

      arr(i) = ((f + s + temp) % 10).toChar
      temp = (f + s + temp) / 10
    }

    arr(length - 1) = temp

    var result = ""
    for (value <- arr.reverse) {
      if (!(result.length == 0 && value == 0)) result += value
    }

    result
  }

  /**
    * a must be larger than b and both be positive
    * @param a
    * @param b
    * @return
    */
  private def subtract(a: String, b: String): String = {

    var s = b
    for (_ <- 0 until a.length - b.length) {
      s = "0" + s
    }

    val first = a.reverse.toCharArray.map(_ - '0')
    val second = s.reverse.toCharArray.map(_ - '0')

    var temp = 0
    val arr = new Array[Int](first.length)
    for (i <- 0 until first.length - 1) {
      temp = first(i) + 10 - second(i) - temp
      arr(i) = temp % 10
      if (temp < 10) temp = 1
      else temp = 0
    }
    arr(first.length - 1) = first.last - temp - second.last
    var result = ""

    for (bit <- arr) {
      result = bit + result
    }

    while (result.startsWith("0")) {
      result = result.substring(1)
    }

    result
  }

}
