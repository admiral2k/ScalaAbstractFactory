package CreationalDesignPatterns.AbstractFactory

object Main extends App{
  val fireUnitSetLvl1 = FireUnitFactory.createBasicUnitSet(1)
  val fireUnitSetLvl5 = FireUnitFactory.createBasicUnitSet(5)

  val snowUnitSetLvl1 = SnowUnitFactory.createBasicUnitSet(1)
  val snowUnitSetLvl5 = SnowUnitFactory.createBasicUnitSet(5)

  val singleSnowWizard = SnowUnitFactory.createWizard(amountOfProjectiles = 10)

  fireUnitSetLvl1.foreach(_.talk())
  fireUnitSetLvl5.foreach(_.talk())

  snowUnitSetLvl1.foreach(_.talk())
  snowUnitSetLvl5.foreach(_.talk())


}
