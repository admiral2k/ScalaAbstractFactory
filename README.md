# Scala Abstract Factory Pattern

This project demonstrates the implementation of the Abstract Factory Design Pattern in Scala. The main objective is to create different types of game units (Archers, Warriors, Wizards) with different themes (Fire, Snow) using the Abstract Factory Pattern.

## Table of Contents

- [Overview](#overview)
- [Game Units](#game-units)
- [Unit Factory](#unit-factory)
- [Main](#main)
- [Usage](#usage)
- [Improvements](#improvements)

## Overview

The main purpose of this project is to implement the Abstract Factory Design Pattern to create themed game units. This project consists of the following main components:

1. **Game Units**: Abstract base classes and concrete implementations for different types of game units.
2. **Unit Factory**: An abstract factory and its concrete implementations for creating game units with different themes.
3. **Main**: The entry point of the application to demonstrate the creation and usage of game units.

## Game Units

The `GameUnit` abstract class and its subclasses represent different types of game units that can be created using the factories.

```scala
package CreationalDesignPatterns.AbstractFactory.Units

abstract class GameUnit(val healthPoints: Int, val attackPoints: Int) {
  def talk(): Unit
  def attack(): Unit
  def statsInfo: String
}

abstract class Archer(healthPoints: Int, attackPoints: Int, val rangeOfShooting: Int) extends GameUnit(healthPoints, attackPoints) {
  override def attack(): Unit = println("Shooting an arrow!")
  def statsInfo: String = s"[HP:$healthPoints AP:$attackPoints RS:$rangeOfShooting]"
}

class FireArcher(healthPoints: Int, attackPoints: Int, rangeOfShooting: Int) extends Archer(healthPoints, attackPoints, rangeOfShooting) {
  override def talk(): Unit = println("I am a Fire Archer!" + statsInfo)
}

class SnowArcher(healthPoints: Int, attackPoints: Int, rangeOfShooting: Int) extends Archer(healthPoints, attackPoints, rangeOfShooting) {
  override def talk(): Unit = println("I am a Snow Archer!" + statsInfo)
}

abstract class Warrior(healthPoints: Int, attackPoints: Int, val rangeOfMeleeAttack: Int) extends GameUnit(healthPoints, attackPoints) {
  override def attack(): Unit = println("A Melee Attack!")
  def statsInfo: String = s"[HP:$healthPoints AP:$attackPoints RMA:$rangeOfMeleeAttack]"
}

class FireWarrior(healthPoints: Int, attackPoints: Int, rangeOfMeleeAttack: Int) extends Warrior(healthPoints, attackPoints, rangeOfMeleeAttack) {
  override def talk(): Unit = println("I am a Fire Warrior!" + statsInfo)
}

class SnowWarrior(healthPoints: Int, attackPoints: Int, rangeOfMeleeAttack: Int) extends Warrior(healthPoints, attackPoints, rangeOfMeleeAttack) {
  override def talk(): Unit = println("I am a Snow Warrior!" + statsInfo)
}

abstract class Wizard(healthPoints: Int, attackPoints: Int, val amountOfProjectiles: Int) extends GameUnit(healthPoints, attackPoints) {
  override def attack(): Unit = println("Casting a spell!")
  def statsInfo: String = s"[HP:$healthPoints AP:$attackPoints AM:$amountOfProjectiles]"
}

class FireWizard(healthPoints: Int, attackPoints: Int, amountOfProjectiles: Int) extends Wizard(healthPoints, attackPoints, amountOfProjectiles) {
  override def talk(): Unit = println("I am a Fire Wizard!" + statsInfo)
}

class SnowWizard(healthPoints: Int, attackPoints: Int, amountOfProjectiles: Int) extends Wizard(healthPoints, attackPoints, amountOfProjectiles) {
  override def talk(): Unit = println("I am a Snow Wizard!" + statsInfo)
}
```

## Unit Factory

The `UnitFactory` trait and its concrete implementations create game units with different themes (Fire, Snow).

```scala
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
  override def createArcher(hp: Int, attack: Int, rangeOfShooting: Int): Archer = new FireArcher(hp, attack, rangeOfShooting)
  override def createWarrior(hp: Int, attack: Int, rangeOfMeleeAttack: Int): Warrior = new FireWarrior(hp, attack, rangeOfMeleeAttack)
  override def createWizard(hp: Int, attack: Int, amountOfProjectiles: Int): Wizard = new FireWizard(hp, attack, amountOfProjectiles)
}

object SnowUnitFactory extends UnitFactory {
  override def createArcher(hp: Int, attack: Int, rangeOfShooting: Int): Archer = new SnowArcher(hp, attack, rangeOfShooting)
  override def createWarrior(hp: Int, attack: Int, rangeOfMeleeAttack: Int): Warrior = new SnowWarrior(hp, attack, rangeOfMeleeAttack)
  override def createWizard(hp: Int, attack: Int, amountOfProjectiles: Int): Wizard = new SnowWizard(hp, attack, amountOfProjectiles)
}
```

## Main

The `Main` object demonstrates the creation and usage of game units.

```scala
package CreationalDesignPatterns.AbstractFactory

object Main extends App {
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
```

## Usage

To run the project, compile the source files and execute the `Main` object. The main method creates various game units with different themes and prints their descriptions.

## Improvements

- Add more unit types and themes.
- Improve the unit stats and abilities.
- Implement additional design patterns to further enhance the flexibility and maintainability of the code.
- Add unit tests to ensure the correctness of the factories and units.
