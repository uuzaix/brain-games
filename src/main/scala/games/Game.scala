package games

import scala.util.Random

case class Round(question: String, correctAnswer: String)

sealed trait Game {
  def intro: String

  def round: Round
}

final case object isEven extends Game {
  val intro = """Answer "yes" if number even otherwise answer "no". Answer "stop" to stop the game"""

  def round: Round = {
    val randomValue = Random.nextInt(100)
    val isEven = if (randomValue % 2 == 0) "yes" else "no"
    new Round(s"Question: ${randomValue}", isEven)
  }
}

final case object Calculations extends Game {
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