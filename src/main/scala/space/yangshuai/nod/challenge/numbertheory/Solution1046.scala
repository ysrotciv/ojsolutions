package space.yangshuai.nod.challenge.numbertheory

/**
  * Created by rotciv on 2017/5/1.
  */
object Solution1046 {

  def main(args: Array[String]): Unit = {
    val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    var b = arr(1)
    val c = arr(2)
    var a = arr(0) % c

    var temp = 1l

    while (b > 2) {
      if (b % 2 == 1) {
        temp = ((a % c) * temp) % c
      }
      a = mod(a, 2, c)
      b /= 2
    }

    for (_ <- 0 until b) {
      temp *= a
      temp %= c
    }

    println(temp)
  }

  private def mod(a: Int, b: Int, c: Int): Int = {
    var temp = 1l
    for (_ <- 0 until b) {
      temp *= a
      temp %= c
    }
    temp.toInt
  }

}
