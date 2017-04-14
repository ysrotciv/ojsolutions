package space.yangshuai.nodsolution.challenge.numbertheory

/**
  * Created by rotciv on 2017/3/7.
  */
object Solution1116 {

  def main(args: Array[String]): Unit = {

    val source = scala.io.Source.stdin.getLines().next()
    var start = 2
    val sum = source.toCharArray.map(c => {
      var value = 0
      if (Character.isDigit(c)) {
        value = c - 48
      } else {
        value = c - 55
      }
      if (value > start) start = value
      value
    }).sum

    for (i <- start to 35) {
      if (sum % i == 0) {
        println(i + 1)
        System.exit(0)
      }
    }

    println("No Solution")
  }

}
