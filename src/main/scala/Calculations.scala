import scala.util.Random
import scala.io.StdIn.readLine

object Calculations {
  def checkAnswer(answer: String, result: Int): Unit = answer match {
    case "stop" => println("The game is stopped")
    case x if x.toInt != result => {
      println("Wrong!")
      round
    }
    case x if x.toInt == result => {
      println("Correct!")
      round
    }
    case _ => {
      println("Let's try again!")
      round
    }
  }

  def round: Unit = {
    val randomX = Random.nextInt(30)
    val randomY = Random.nextInt(30)
    val randomOperator = Random.nextInt(2)
    val operator = Array("+", "*")
    println(s"Question: ${randomX} ${operator(randomOperator)} ${randomY}")
    val answer = readLine()
    val result = randomOperator match {
      case 0 => randomX + randomY
      case 1 => randomX * randomY
    }
    checkAnswer(answer, result)
  }
  def game: Unit = {
    println("What is the result of the expression?")
    round
  }

  def main(args: Array[String]): Unit = {
    game
  }
}
