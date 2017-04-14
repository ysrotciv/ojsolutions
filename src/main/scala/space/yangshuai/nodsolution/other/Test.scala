package space.yangshuai.nodsolution.other

import scala.collection.mutable

/**
  * Created by rotciv on 2017/3/4.
  */
object Test extends App {

  val queue = new mutable.PriorityQueue[Int]()

  queue.enqueue(1)
  queue.enqueue(10)

  while (queue.nonEmpty) {
    println(queue.dequeue())
  }

}
