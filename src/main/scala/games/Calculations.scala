package games

import scala.util.Random

case object Calculations extends Game {
  val name = "Calculations"
  val intro = "What is the result of the expression?"

  def round: Round = {
    val randomX = Random.nextInt(30)
    val randomY = Random.nextInt(30)
    val randomOperator = Random.nextInt(2)
    val operator = Array("+", "*")
    val result = randomOperator match {
      case 0 => randomX + randomY
      case 1 => randomX * randomY
    }
    new Round(s"Question: ${randomX} ${operator(randomOperator)} ${randomY}", result.toString)
  }
}
