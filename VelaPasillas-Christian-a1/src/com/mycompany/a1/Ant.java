// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;

public class Ant extends MovableGameObject implements IFoodie  {  // I Define the Ant class here, which extends MovableGameObject and implements IFoodie
    
	// variables of ant class
	private int maximumSpeed;
  	private int foodConsumptionRate;
	private int healthLevel;
	private int lastFlagReached;
	
    public Ant(float a, float b, int initialHeading, int initialSpeed, int foodLevel) { // Constructor for creating an Ant object
    	super(20, a, b, 255, 0, 0, initialHeading, initialSpeed, foodLevel);	// Call the constructor of the superclass (MovableGameObject)
		
    	// Initialize  variables
    	this.maximumSpeed = 30;
		this.foodConsumptionRate = 2;
		this.healthLevel = 10;
		this.lastFlagReached = 1;
    }
    @Override
	public void changesHead(int headingChange) { // This is the method to change the heading of the Ant
		int newHeading; 
		if (this.getInitialHeading() + headingChange >= 360) {  // Heading remains in the range [0, 359]
			newHeading = ((this.getInitialHeading() + headingChange) - 360);
			this.setInitialHeading(newHeading);
		} else if (this.getInitialHeading() + headingChange <= 0) {
			newHeading = ((this.getInitialHeading() + headingChange) + 360);
			this.setInitialHeading(newHeading);
		} else {
			this.setInitialHeading(this.getInitialHeading() + headingChange);
		}
	}
    public int getMaximumSpeed() { // Getter for maximumSpeed
		return this.maximumSpeed;
	}

	public void setMaximumSpeed(int maximumSpeed) { // Setter for maximumSpeed
		this.maximumSpeed = maximumSpeed;
	}
	
	public int getFoodConsumptionRate() { // Getter for foodConsumptionRate
		return this.foodConsumptionRate;
	}
	
	public void setFoodConsumptionRate(int foodConsumptionRate) { // Setter for foodConsumptionRate
		this.foodConsumptionRate = foodConsumptionRate;
	}
	
	public int getHealthLevel() { // Getter for healthLevel
		return this.healthLevel;
	}
	
	public void setHealthLevel(int healthLevel) { // Setter for healthLevel
		this.healthLevel = healthLevel;
	}
	
	public int getLastFlagReached() { // Getter for lastFlagReached
		return this.lastFlagReached;
	}
	
	public void setLastFlagReached(int lastFlagReached) { // Setter for lastFlagReached
		this.lastFlagReached = lastFlagReached;
	}
	@Override
	public void move(int initialHeading, int initialSpeed) { // Implement the movement logic for Ant if it is needed
		
	}
	@Override
	public String toString() {
		return "Ant: " + this.printLocation() + " " + this.printColor() + " heading = " + this.getInitialHeading() + " speed = " + this.getInitialSpeed() + " " + this.printSize() + " maximumSpeed = " + this.maximumSpeed + " foodConsumptionRate = " + this.foodConsumptionRate;
	}
}
