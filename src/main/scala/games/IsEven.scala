package games

import scala.util.Random

case object isEven extends Game {
  val intro = """Answer "yes" if number even otherwise answer "no". Answer "stop" to stop the game"""

  def round: Round = {
    val randomValue = Random.nextInt(100)
    val isEven = if (randomValue % 2 == 0) "yes" else "no"
    new Round(s"Question: ${randomValue}", isEven)
  }
}