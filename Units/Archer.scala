package CreationalDesignPatterns.AbstractFactory.Units

abstract class Archer(
                       healthPoints: Int,
                       attackPoints: Int,
                       val rangeOfShooting: Int)
  extends GameUnit(healthPoints, attackPoints) {

  override def attack(): Unit = println("Shooting an arrow!")

  def statsInfo: String = s"[HP:$healthPoints AP:$attackPoints RS:$rangeOfShooting]"
}

class FireArcher(
                  healthPoints: Int,
                  attackPoints: Int,
                  rangeOfShooting: Int)
  extends Archer(healthPoints, attackPoints, rangeOfShooting) {
  override def talk(): Unit = println("I am a Fire Archer!" + statsInfo)
}

class SnowArcher(
                  healthPoints: Int,
                  attackPoints: Int,
                  rangeOfShooting: Int)
  extends Archer(healthPoints, attackPoints, rangeOfShooting) {
  override def talk(): Unit = println("I am a Snow Archer!" + statsInfo)
}
