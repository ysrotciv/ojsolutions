package space.yangshuai.nodsolution.challenge.string

/**
  * Created by rotciv on 2017/3/4.
  */
object Solution1277b {

  def main(args: Array[String]): Unit = {

    val source = scala.io.Source.stdin.getLines().next().toArray
    val headChar = source(0)
    val sourceLength = source.length
    var max = sourceLength
    val count = new Array[Int](sourceLength - 2)

    for (i <- 1 until sourceLength - 1) {
      var length = 1
      if (source(i) == headChar) {
        while ((i + length) < sourceLength && source(i + length) == source(length)) {
          count(length - 1) += 1
          length += 1
        }
      }
    }

    for (i <- 2 until sourceLength) {
      val value = (1 + count(i - 2)) * i
      if (value > max) {
        max = value
        println(i)
        println(count(i - 2) + 1)
      }
    }

    println(max)
  }

}
