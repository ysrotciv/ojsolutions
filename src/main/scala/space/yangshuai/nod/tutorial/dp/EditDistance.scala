package space.yangshuai.nod.tutorial.dp

/**
  * Created on 2017/4/18.
  *
  * @author shuai.yang
  */
object EditDistance {

  def main(args: Array[String]): Unit = {
    val a = scala.io.StdIn.readLine().toCharArray
    val b = scala.io.StdIn.readLine().toCharArray

    val upper = new Array[Int](b.length + 1)
    val current = new Array[Int](b.length + 1)

    for (y <- 0 to a.length) {
      System.arraycopy(current, 0, upper, 0, b.length + 1)
      for (x <- 0 to b.length) {
        if (x == 0) {
          current(x) = y
        } else if (y == 0) {
          current(x) = x
        } else {
          current(x) = min(upper(x - 1) + same(a(y - 1), b(x - 1)), upper(x) + 1, current(x - 1) + 1)
        }
      }
    }

    println(current(b.length))
  }

  def same(a: Char, b: Char): Int = {
    if (a == b) {
      0
    } else {
      1
    }
  }

  def min(a: Int, b: Int, c: Int): Int = {
    if (a > b) {
      if (b < c) {
        b
      } else {
        c
      }
    } else {
      if (a < c) {
        a
      } else {
        c
      }
    }
  }
}
