import scala.util.Random
import scala.io.StdIn.readLine

object Game {
  def checkAnswer(answer: String, isEven: Boolean) = answer match {
    case "stop" => println("The game is stopped")
    case "no" => {
      isEven match {
        case true => println("Wrong!")
        case false => println("Correct!")
      }
      round
    }
    case "yes" => {
      isEven match {
        case false => println("Wrong!")
        case true => println("Correct!")
      }
      round
    }
    case _ => {
      println("Let's try again")
      round
    }
  }

  def round: Unit = {
    val randomValue = Random.nextInt(100)
    println(s"Question: ${randomValue}")
    val answer = readLine()
    val isEven = randomValue % 2 == 0
    checkAnswer(answer, isEven)
  }
  def game = {
    println("""Answer "yes" if number even otherwise answer "no". Answer "stop" to stop the game""")
    round
  }

  def main(args: Array[String]): Unit = {
    game
  }
}
