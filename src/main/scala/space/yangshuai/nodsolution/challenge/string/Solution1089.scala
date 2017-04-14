package space.yangshuai.nodsolution.challenge.string

/**
  * Created by rotciv on 2017/3/3.
  */
object Solution1089 {

  def main(args: Array[String]): Unit = {

    val source = scala.io.Source.stdin.getLines().next()

    val arr = new Array[Char](source.length * 2 + 2)
    arr(0) = '$'
    arr(1) = '#'
    var i = 2

    for (c <- source) {
      arr(i) = c
      arr(i + 1) = '#'
      i = i + 2
    }

    val rl = new Array[Int](arr.length)
    rl(0) = 0
    rl(1) = 0
    rl(2) = 1

    var maxRight = 3
    var pos = 2
    var radius = 0
    i = 3

    while (i < arr.length - 2) {
      if (i < maxRight) {
        radius = min(rl(pos * 2 - i), maxRight - i)
        while ((i + radius + 1 <= arr.length - 1) && arr(i + radius + 1) == arr(i - radius - 1)) {
          radius += 1
        }
        if (radius + i > maxRight) {
          maxRight = radius + i
          pos = i
        }
      } else {
        radius = 0
        while ((i + radius + 1 <= arr.length - 1) && arr(i + radius + 1) == arr(i - radius - 1)) {
          radius += 1
        }
        maxRight = radius + i
        pos = i
      }
      rl(i) = radius

      i += 1
    }

    var max = 1
    for (length <- rl) {
      if (length > max) max = length
    }

    println(max)
  }

  private def min(a: Int, b: Int): Int = {
    if (a < b) return a
    b
  }

}
