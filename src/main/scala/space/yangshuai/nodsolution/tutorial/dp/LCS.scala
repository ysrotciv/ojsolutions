package space.yangshuai.nodsolution.tutorial.dp

/**
  * Created by rotciv on 2017/4/17.
  */
object LCS {

  def main(args: Array[String]): Unit = {
    val a = scala.io.StdIn.readLine().toCharArray
    val b = scala.io.StdIn.readLine().toCharArray

    val builder = new StringBuilder()

    val matrix = Array.ofDim[Int](a.length + 1, b.length + 1)

    for (i <- 0 to a.length) {
      for (j <- 0 to b.length) {
        if (i == 0 || j == 0) {
          matrix(i)(j) = 0
        } else {
          if (a(i - 1) == b(j - 1)) {
            matrix(i)(j) = matrix(i - 1)(j - 1) + 1
          } else {
            matrix(i)(j) = max(matrix(i - 1)(j), matrix(i)(j - 1))
          }
        }
      }
    }

    var x = a.length
    var y = b.length

    while (x > 0 && y > 0) {
      if (a(x - 1) == b(y - 1)) {
        builder.append(a(x - 1))
        x -= 1
        y -= 1
      } else {
        if (matrix(x - 1)(y) >= matrix(x)(y - 1)) {
          x -= 1
        } else {
          y -= 1
        }
      }
    }

    println(builder.reverse.toString())
  }

  private def max(one: Int, another: Int): Int = {
    if (one > another) {
      one
    } else {
      another
    }
  }

}
