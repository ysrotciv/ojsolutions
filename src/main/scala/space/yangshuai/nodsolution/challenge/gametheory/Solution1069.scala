package space.yangshuai.nodsolution.challenge.gametheory

/**
  * Created by rotciv on 2017/5/1.
  */
object Solution1069 {

  def main(args: Array[String]): Unit = {
    var ans = ""
    val n = scala.io.StdIn.readLine().toInt
    var biggerThanOne = 0
    var total = 0
    for (_ <- 0 until n) {
      val value = scala.io.StdIn.readLine().toInt
      if (value > 1) {
        biggerThanOne += 1
        total += value
      }
    }

    if (n % 2 == 0) {
      if (biggerThanOne == 0) {
        ans = "B"
      } else if (biggerThanOne == 1) {
        ans = "A"
      } else {
        if (total % 2 == 0) {
          ans = "A"
        } else {
          ans = "B"
        }
      }
    } else {
      if (biggerThanOne <= 1) {
        ans = "A"
      } else {
        if (total % 2 == 0) {
          ans = "B"
        } else {
          ans = "A"
        }
      }
    }

    println(ans)
  }

}
