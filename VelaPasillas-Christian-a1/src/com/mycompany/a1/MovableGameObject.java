// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;

public abstract class MovableGameObject extends GameObject { // I Define a class named MovableGameObject that extends GameObject
    private int initialHeading;
    private int initialSpeed;
    private int foodLevel;


	// z is the size of the object and a, b are coordinates of the object
    public MovableGameObject(int z, float a, float b, int redComponent, int greenComponent, int blueComponent, int initialHeading, int initialSpeed, int foodLevel) {
	    super(z, a, b, redComponent, greenComponent, blueComponent); // Color components
		this.initialHeading = initialHeading;  //Initial heading of the movable object
		this.initialSpeed = initialSpeed;   //Initial speed of the movable object
		this.foodLevel = foodLevel;
    }
    
	public abstract void move(int initialHeading, int initialSpeed);   // Abstract method for moving the object
	
	public String printInitialHeading() { // Method to print the object's heading
		return "heading = " + this.initialHeading;
	}

	public int getInitialHeading() {  // Getter for initial heading
		return this.initialHeading;
    }
    
    public void setInitialHeading(int initialHeading) { // Setter for initial heading with validation
    	if (initialHeading >= 0 && initialHeading <= 360)
			this.initialHeading = initialHeading;
    }
    
    public String printInitialSpeed() { // Method to print the object's speed
		return "speed = " + this.initialSpeed;
	}
    
    public int getInitialSpeed() {  // Getter for initial speed
    	return this.initialSpeed;
    }
    
    public void setInitialSpeed(int initialSpeed) { // Setter for initial speed
        this.initialSpeed = initialSpeed;
    }

	public int getFoodLevel() {  // Getter for foodLevel speed
		return foodLevel;
	}

	public void setFoodLevel(int foodLevel) {  // Setter for foodLevel
		this.foodLevel = foodLevel;
	}
    
}

