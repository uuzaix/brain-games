import scala.io.StdIn.readLine
import games.{Calculations, Game, isEven}

case class Engine(game: Game) {
  def startGame(): Unit = {
    println(game.intro)
    runRound()
  }

  private def runRound(): Unit = {
    val round = game.round
    println(round.question)
    val answer = readLine()
    if (checkAnswer(answer, round.correctAnswer)) runRound()
  }

  private def checkAnswer(answer: String, correctAnswer: String): Boolean = answer match {
    case "stop" => {
      println("The game is stopped")
      false
    }
    case a if a == correctAnswer => {
      println("Correct!")
      true
    }
    case _ => {
      println("Wrong!")
      true
    }
  }
}

object Engine {
  def main(args: Array[String]): Unit = {
    val engine = Engine(Calculations)
    //    val engine = Engine(isEven)
    engine.startGame()
  }
}
