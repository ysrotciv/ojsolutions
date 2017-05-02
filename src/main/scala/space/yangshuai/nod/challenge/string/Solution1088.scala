package space.yangshuai.nod.challenge.string

/**
  * Created by rotciv on 2017/3/3.
  */
object Solution1088 {

  def main(args: Array[String]): Unit = {

    val source = scala.io.Source.stdin.getLines().next()
    val length = source.length
    for (i <- 0 to length - 2) {
      for (j <- 0 to i) {
        val sub = source.substring(j, j + (length - i))
        if (ifPalindrom(sub)) {
          println(length - i)
          return
        }
      }
    }

    println(1)
  }

  private def ifPalindrom(str: String): Boolean = {

    val length = str.length
    var i = 0

    while (i < length - i - 1) {
      val low = str.charAt(i)
      val high = str.charAt(str.length - i - 1)
      if (low != high)
        return false
      else {
        i += 1
      }
    }

    true
  }

}
