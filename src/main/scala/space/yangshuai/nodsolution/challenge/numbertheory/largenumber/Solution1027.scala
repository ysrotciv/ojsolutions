package space.yangshuai.nodsolution.challenge.numbertheory.largenumber

import scala.collection.mutable.ListBuffer

/**
  * Created on 2017/4/28.
  *
  * @author shuai.yang
  */
object Solution1027 {

  def main(args: Array[String]): Unit = {
    var a = scala.io.StdIn.readLine()
    var b = scala.io.StdIn.readLine()

    if (a.length < b.length) {
      val temp = a
      a = b
      b = temp
    }

    println(multi(a, b))
  }

  private def multi(a: String, b: String): String = {
    var sum = "0"
    var zeroes = 0
    for (c <- b.toCharArray.reverse) {
      var temp = bitMulti(a, c - '0')
      for (_ <- 0 until zeroes) {
        temp += "0"
      }
      sum = add(sum, temp)
      zeroes += 1
    }
    sum
  }

  private def bitMulti(a: String, b: Int): String = {
    val builder = new StringBuilder()
    val aArr = a.toCharArray.reverse
    var temp = 0
    for (c <- aArr) {
      val result = (c - '0') * b + temp
      builder.append(result % 10)
      temp = result / 10
    }
    if (temp > 0) {
      builder.append(temp)
    }

    builder.reverse.toString()
  }

  private def add(a: String, b: String): String = {
    val aArr = a.toCharArray.reverse
    val bArr = b.toCharArray.reverse
    val builder = new StringBuilder()

    var index = 0
    var temp = 0

    while (index < a.length || index < b.length) {
      var aValue = 0
      if (index < a.length) {
        aValue = aArr(index) - '0'
      }
      var bValue = 0
      if (index < b.length) {
        bValue = bArr(index) - '0'
      }
      val sum = temp + aValue + bValue
      builder.append(sum % 10)
      temp = sum / 10
      index += 1
    }

    if (temp > 0) {
      builder.append(temp)
    }

    builder.reverse.toString()
  }

}
