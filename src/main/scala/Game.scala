object Game {
  def main(args: Array[String]): Unit = {
    def game = {
      println("Answer \"yes\" if number even otherwise answer \"no\". Answer \"stop\" to stop the game")

      def round: Unit = {
        val r = scala.util.Random
        val randomValue =  r.nextInt(100)
        println(s"Question: ${randomValue}")
        val answer = scala.io.StdIn.readLine()
        val isEven = if (randomValue % 2 == 0) true else false
        checkAnswer(answer, isEven)
      }

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
      round
    }
    game
  }
}
