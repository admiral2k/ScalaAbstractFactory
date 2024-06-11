package CreationalDesignPatterns.AbstractFactory.Units

abstract class Warrior(
                       healthPoints: Int,
                       attackPoints: Int,
                       val rangeOfMeleeAttack: Int)
  extends GameUnit(healthPoints, attackPoints) {

  override def attack(): Unit = println("A Melee Attack!")

  def statsInfo: String = s"[HP:$healthPoints AP:$attackPoints RMA:$rangeOfMeleeAttack]"
}

class FireWarrior(
                  healthPoints: Int,
                  attackPoints: Int,
                  rangeOfMeleeAttack: Int)
  extends Warrior(healthPoints, attackPoints, rangeOfMeleeAttack) {
  override def talk(): Unit = println("I am a Fire Warrior!" + statsInfo)
}

class SnowWarrior(
                  healthPoints: Int,
                  attackPoints: Int,
                  rangeOfMeleeAttack: Int)
  extends Warrior(healthPoints, attackPoints, rangeOfMeleeAttack) {
  override def talk(): Unit = println("I am a Snow Warrior!"+ statsInfo)
}