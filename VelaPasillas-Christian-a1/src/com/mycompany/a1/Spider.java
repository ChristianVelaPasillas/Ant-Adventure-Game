// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;

public class Spider extends MovableGameObject { // I Define a class named Spider that extends MovableGameObject

	public Spider(int z, float a, float b, int initialHeading, int initialSpeed, int foodLevel) {
		super(z, a, b, 0, 0, 0, initialHeading, initialSpeed, foodLevel);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Spider: " + this.printLocation() + " " + this.printColor() + " " + this.printInitialHeading() + " " + this.printInitialSpeed() + " " + this.printSize();
	}
	
	@Override
	public void setColor(int redComponent, int greenComponent, int blueComponent) {
 }

	public void move(int initialHeading, int initialSpeed) { // Here I calculate delta x and delta y based on initialHeading and initialSpeed
		
			float deltaX = (float) (Math.cos(Math.toRadians(90 - initialHeading)) * initialSpeed);
			float deltaY = (float) (Math.sin(Math.toRadians(90 - initialHeading)) * initialSpeed);
			
			float newX = this.getObjectLocation().getX() + deltaX; // Here, I calculate new coordinates
			float newY = this.getObjectLocation().getY() + deltaY;
			
			if (newX <= 0.0 || newX >= 1024.0) { // Here I handle boundary conditions
				if (initialHeading < 180)
					initialHeading += 180;
				else if (initialHeading > 180)
					initialHeading -= 180;
				else if (initialHeading == 180)
					initialHeading = 0;
				
				deltaX = (float) (Math.cos(Math.toRadians(90 - initialHeading)) * initialSpeed); // Here I recalculate delta x and delta y
				deltaY = (float) (Math.sin(Math.toRadians(90 - initialHeading)) * initialSpeed);
				
				newX = this.getObjectLocation().getX() + deltaX;  // Here I recalculate new coordinates
				newY = this.getObjectLocation().getY() + deltaY;
			}
			
			if (newY <= 0.0 || newY >= 768.0) { // Here I adjust heading when hitting vertical boundaries
				if (initialHeading < 180)
					initialHeading += 180;
				else if (initialHeading > 180)
					initialHeading -= 180;
				else if (initialHeading == 180)
					initialHeading = 0;
				
				deltaX = (float) (Math.cos(Math.toRadians(90 - initialHeading)) * initialSpeed); // Here I recalculate delta x and delta y
				deltaY = (float) (Math.sin(Math.toRadians(90 - initialHeading)) * initialSpeed);
				
				newX = this.getObjectLocation().getX() + deltaX;  // Here I recalculate new coordinates
				newY = this.getObjectLocation().getY() + deltaY;
			}
			this.setLocation(newX, newY);  // Set the new location for the spider
		}
}
