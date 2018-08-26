import scala.io.StdIn.readLine

import games.{Game, isEven, Calculations}

case class Engine(game: Game) {
  def startGame(): Unit = {
    println(game.intro)
    runRound()
  }
  def runRound(): Unit = {
    val round = game.round
    println(round.question)
    val answer = readLine()
    checkAnswer(answer, round.correctAnswer)
  }
  def checkAnswer(answer: String, correctAnswer: String): Unit = answer match {
    case "stop" => println("The game is stopped")
    case a if a == correctAnswer => {
       println("Correct!")
      runRound()
    }
    case _ => {
      println("Wrong!")
      runRound()
    }
  }
}

object Engine {
  def main(args: Array[String]): Unit = {
    val engine = new Engine(Calculations)
//    val engine = new Engine(isEven)
    engine.startGame()
  }
}
