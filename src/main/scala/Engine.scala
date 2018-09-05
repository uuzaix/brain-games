import scala.io.StdIn.readLine
import games.{Calculations, Game, isEven}

case class Engine(game: Game) {
  def startGame(): Unit = {
//    println(s"Game ${game.name} is started")
    println("Game  is started")
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
  def selectGame(): String = {
    println("Type the name of the game you want to play: Calculations, IsEven. Or press enter for default game.")
    readLine()
  }

  def main(args: Array[String]): Unit = {
    val gameName = if (args.isEmpty) selectGame() else args(0)

    val engine = gameName match {
      case "Calculations" => Engine(Calculations)
      case "IsEven" => Engine(isEven)
      case _ => Engine(isEven)
    }
    engine.startGame()
  }
}
