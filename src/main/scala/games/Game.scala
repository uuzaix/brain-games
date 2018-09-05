package games

case class Round(question: String, correctAnswer: String)

trait Game {
  def intro: String
  def round: Round
}