package CreationalDesignPatterns.AbstractFactory.Units

abstract class GameUnit(val healthPoints: Int, val attackPoints: Int) {
  def talk(): Unit

  def attack(): Unit

  def statsInfo: String
}
