// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.charts.models.Point;

public abstract class MovableGameObject extends GameObject{
	
	private int objectSpeed = 0;
	private int objectDirection;
	private int size;
	
	public MovableGameObject() {
	
		setSpeed(getRandom(5) + 5);
		setDirection(getRandom(359));
	
	}
	/**
	 * Method to move all movable objects in game
	 */
	public void moveNew() {
		
		Point oldLocation = (getLocation());
		Point newLocation = new Point(0, 0);
		
		int theta = 90 - getDirection();
		double deltaX = 0;
		double deltaY = 0;
		
		//Horizontal movement
		if(getDirection() == 90 || getDirection() == 270) {
			deltaX = Math.cos(Math.toRadians(theta)) * this.objectSpeed;
		}
		//Vertical movement
		else if(getDirection() == 0 || getDirection() == 180) {
			deltaY = Math.sin(Math.toRadians(theta)) * this.objectSpeed;
		}
		//Diagonal movement
		else {
			deltaX = Math.cos(Math.toRadians(theta)) * this.objectSpeed;
			deltaY = Math.sin(Math.toRadians(theta)) * this.objectSpeed;
		}
		newLocation.setX((float) (deltaX + oldLocation.getX()));
		newLocation.setY((float) (deltaY + oldLocation.getY()));
		
		newLocation.setX(newLocation.getX());
		newLocation.setY(newLocation.getY());
		
		setLocation(newLocation);
	
	}
	
	public void setSize(int i) {
		
		size = i;
	}
	
	public int getSize() {
		
		return size;
	}
	/**
	 * Method to set object speed
	 * 
	 * @param x
	 */
	public void setSpeed(int x) {
		
		this.objectSpeed = x;
	}
	/**
	 * Method to request object speed
	 * 
	 * @return objectSpeed
	 */
	public int getSpeed() {
		
		return this.objectSpeed;
	}
	/**
	 * Method to request object direction
	 * 
	 * @return objectDirection
	 */
	public int getDirection() {
		
		return objectDirection;
	}
	/**
	 * Method to set object direction
	 * 
	 * @param x
	 */
	public void setDirection(int x) {
		
		this.objectDirection = x;
	}
	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString();
		String value = " heading= " + getDirection() 
		+ " speed= " + getSpeed();
		
		String concValue = supString + value;
	
		return concValue;
	}
}