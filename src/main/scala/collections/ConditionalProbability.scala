package collections

import scala.collection.mutable.ListBuffer

class ConditionalProbability(binSize: Int = 6) {

  private val WhiteBall: Int = 1
  private val BlackBall: Int = 0

  private val bin: ListBuffer[Int] = ListBuffer.fill(binSize)(scala.util.Random.nextInt(2))

  def getBalls: Boolean = {
    val r = new scala.util.Random(10)
    val firstBall = bin.remove(r.nextInt(bin.size))

    firstBall match {
      case BlackBall =>
        val secondBall = bin.remove(r.nextInt(bin.size))
        println(s"first ball = Black($firstBall), second ball = White($secondBall)")
        if (secondBall == WhiteBall) true else false
      case WhiteBall =>
        println(s"first ball = White($firstBall)")
        false
    }
  }

  override def toString: String = bin.mkString(", ")
}

object TestCondinionalProbability extends App {

  val cp1 = List.fill(10000)(new ConditionalProbability)
  val result = cp1.map { x =>
    x.getBalls
  }

  val countTrue = result.count(_ == true)

  val check = countTrue / result.size.toDouble

  println(check)
}