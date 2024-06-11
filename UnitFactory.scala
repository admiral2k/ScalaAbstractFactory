package CreationalDesignPatterns.AbstractFactory

import CreationalDesignPatterns.AbstractFactory.Units._

trait UnitFactory {
  def createArcher(hp: Int = 1, attack: Int = 1, rangeOfShooting: Int = 1): Archer
  def createWarrior(hp: Int = 1, attack: Int = 1, rangeOfMeleeAttack: Int = 1): Warrior
  def createWizard(hp: Int = 1, attack: Int = 1, amountOfProjectiles: Int = 1): Wizard
  def createBasicUnitSet(level: Int): List[GameUnit] = List(
    createArcher(level, level, level),
    createWarrior(level, level, level),
    createWizard(level, level, level))
}

object FireUnitFactory extends UnitFactory {
  override def createArcher(hp: Int, attack: Int, rangeOfShooting: Int): Archer =  new FireArcher(hp, attack, rangeOfShooting)

  override def createWarrior(hp: Int, attack: Int, rangeOfMeleeAttack: Int): Warrior = new FireWarrior(hp, attack, rangeOfMeleeAttack)

  override def createWizard(hp: Int, attack: Int, amountOfProjectiles: Int): Wizard = new FireWizard(hp, attack, amountOfProjectiles)
}

object SnowUnitFactory extends UnitFactory {
  override def createArcher(hp: Int, attack: Int, rangeOfShooting: Int): Archer = new SnowArcher(hp, attack, rangeOfShooting)

  override def createWarrior(hp: Int, attack: Int, rangeOfMeleeAttack: Int): Warrior = new SnowWarrior(hp, attack, rangeOfMeleeAttack)

  override def createWizard(hp: Int, attack: Int, amountOfProjectiles: Int): Wizard = new SnowWizard(hp, attack, amountOfProjectiles)
}
