package space.yangshuai.nodsolution.challenge.string

/**
  * Created by rotciv on 2017/3/3.
  */
object Solution1183 {

  def main(args: Array[String]): Unit = {

    val iterator = scala.io.Source.stdin.getLines()
    val a = iterator.next()
    val b = iterator.next()

    println(editDistance(a, b))
  }

  private def editDistance(a: String, b: String): Int = {

    val m = a.length
    val n = b.length

    val d2 = Array.ofDim[Int](m + 1, n + 1)

    for (i <- 0 to m) {
      for (j <- 0 to n) {
        if (i == 0) {
          d2(i)(j) = j
        } else if (j == 0) {
          d2(i)(j) = i
        } else {
          if (a.charAt(i - 1) == b.charAt(j - 1)) {
            d2(i)(j) = d2(i - 1)(j - 1)
          } else {
            d2(i)(j) = min(d2(i - 1)(j), d2(i - 1)(j - 1), d2(i)(j - 1)) + 1
          }
        }
      }
    }

    d2(m)(n)
  }

  private def min(a: Int, b: Int, c: Int): Int = {
    if (a <= b && a <= c) return a
    if (b <= a && b <= c) return b
    c
  }

}
