package CreationalDesignPatterns.AbstractFactory

import CreationalDesignPatterns.AbstractFactory.Units.GameUnit
import scala.io.StdIn.readLine

object Utilities {
  // bad, but okay for testing
  def clearConsole() = for {_ <- 1 to 200} println()
}

object Test extends App{
  // additional variables
  var isRunning = true
  var unitList: List[GameUnit] = List()
  var input = ""
  var message = ""
  var currentFactory: UnitFactory = FireUnitFactory

  // main loop
  while(isRunning){
    // clearing the console
    Utilities.clearConsole()

    //message:
    println(s"Info: $message\n")

    //drawing current factory
    currentFactory match {
      case FireUnitFactory => println("Chosen factory: FireUnitFactory\n")
      case SnowUnitFactory => println("Chosen factory: SnowUnitFactory\n")
    }

    //drawing Units
    if (unitList.isEmpty) println("No units. Create one!")
    else {
      unitList.foreach(_.talk())
    }

    //printing possible commands
    println()
    print(
      """1 Create an Archer
        |2 Create an Warrior
        |3 Create an Wizard
        |4 Clear a field
        |5 Toggle the Factory Type (Fire/Snow)
        |6 Exit
        |>""".stripMargin)

    //waiting for user's input
    input = readLine()

    //processing
    input match {
      case "1" => unitList = unitList :+ currentFactory.createArcher(); message = "Created an Archer"
      case "2" => unitList = unitList :+ currentFactory.createWarrior(); message = "Created an Warrior"
      case "3" => unitList = unitList :+ currentFactory.createWizard(); message = "Created an Wizard"
      case "4" => unitList = List(); message = "Cleared a field"
      case "5" if currentFactory.equals(FireUnitFactory) => {
        currentFactory = SnowUnitFactory
        message = "Switched to Snow Unit Factory"
      }
      case "5" if currentFactory.equals(SnowUnitFactory) => {
        currentFactory = FireUnitFactory
        message = "Switched to Fire" +
          " Unit Factory"
      }
      case "6" => {
        isRunning = false
        println("Bye!")
      }
      case _ => message = "Wrong input."
    }
  }
}
