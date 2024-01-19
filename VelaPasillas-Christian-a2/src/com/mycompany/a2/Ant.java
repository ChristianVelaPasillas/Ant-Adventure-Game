// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

public class Ant extends MovableGameObject implements IFoodie{
	
	private int maxSpeed;
	private int foodConsumptionRate;
	private int speed;
	private int direction;
	private int lastFlagReached;
	private int healthLevel;
	private static Ant theAnt;
	
	public Ant() {
		
		maxSpeed = 50;
		setSize(40);
		setColor(255, 0, 0); //Red
		setFoodConsumptionRate(2);
		setSpeed(30);
		speed = getSpeed();
		setDirection(0);
		direction = getDirection();
	}
	
	//Singleton implementation
	public static Ant getTheAnt() {
		
		if(theAnt == null) 
			theAnt = new Ant();
		return theAnt;
	}
	
	public void resetLocation() {
		
		setLocationX(0);
		setLocationY(0);
	}
	/*
	 * Method to set consumption rate
	 */
	public void setFoodConsumptionRate(int r) {
		
		foodConsumptionRate = r;
	}
	/*
	 * Method to get consumption rate
	 */
	public int getFoodConsumptionRate() {
		
		return foodConsumptionRate;
	}
	
	/**
	 * Method to change Ant speed
	 * 
	 * @param c
	 */
	public void changeSpeed(char c) {
		
		switch(c) {
		
		case 'a' :
			if(speed >= 50) {
				speed = speed - 5;
				System.out.println("Ant can't go any faster!");
				break;
			}
			else
				speed = speed + 5;
				System.out.println("\nAnt has accelerated!");
				System.out.println("Speed of Ant is now: " + speed);
				setSpeed(speed);
				break;
				
		case 'b' :
			if(speed <= 0) {
				speed = 0;
				System.out.println("Ant has lost all speed!");
				break;
			}
			else 
			speed = speed - 5;
			System.out.println("\nAnt has slowed down!");
			System.out.println("Speed of Ant is now: " + speed);
			setSpeed(speed);
			break;
			
		default:
			break;
			
		}
	}
	//Method created to change heading of Ant
	
	/**
	 * @param c
	 */
	@Override
	public void changeDirection(char c) {
		
		switch(c) {
		
		case 'r' :
			direction = direction - 5;
			System.out.println("\nAnt has turned right!");
			System.out.println("Heading of Ant is now: " + direction);
			setDirection(direction);
			break;
			
		case 'l' :
			direction = direction + 5;
			System.out.println("\nAnt has turned left!");
			System.out.println("Heading of Ant is now: " + direction);
			setDirection(direction);
			break;
		}
		
	}

	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString();
		String value = " size= " + getSize() + " maxSpeed= " + maxSpeed + 
				" foodConsumptionRate= " + foodConsumptionRate;
		
		String concValue = "Ant:    " + supString + value;
		
		return concValue;
	}

	public int getLastFlagReached() {
		return lastFlagReached;
	}

	public void setLastFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}


}
