package space.yangshuai.nod.challenge.numbertheory.largenumber

/**
  * Created on 2017/4/28.
  *
  * @author shuai.yang
  */
object Solution1027 {

  var arr: Array[Int] = _

  def main(args: Array[String]): Unit = {

    var a = scala.io.StdIn.readLine().toCharArray
    var b = scala.io.StdIn.readLine().toCharArray

    arr = new Array[Int](a.length + b.length)

    if (a.length < b.length) {
      val temp = a
      a = b
      b = temp
    }

    multi(a.reverse, b.reverse)

    println(arr.reverse.dropWhile(_ == 0).mkString(""))
  }

  private def multi(a: Array[Char], b: Array[Char]): Unit = {

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
