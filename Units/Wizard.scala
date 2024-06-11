package CreationalDesignPatterns.AbstractFactory.Units

abstract class Wizard(
                       healthPoints: Int,
                       attackPoints: Int,
                       val amountOfProjectiles: Int)
  extends GameUnit(healthPoints, attackPoints) {

  override def attack(): Unit = println("Casting a spell!")

  def statsInfo: String = s"[HP:$healthPoints AP:$attackPoints AM:$amountOfProjectiles]"
}

class FireWizard(
                  healthPoints: Int,
                  attackPoints: Int,
                  amountOfProjectiles: Int)
  extends Wizard(healthPoints, attackPoints, amountOfProjectiles) {
  override def talk(): Unit = println("I am a Fire Wizard!" + statsInfo)
}

class SnowWizard(
                  healthPoints: Int,
                  attackPoints: Int,
                  amountOfProjectiles: Int)
  extends Wizard(healthPoints, attackPoints, amountOfProjectiles) {
  override def talk(): Unit = println("I am a Snow Wizard!" + statsInfo)
}
