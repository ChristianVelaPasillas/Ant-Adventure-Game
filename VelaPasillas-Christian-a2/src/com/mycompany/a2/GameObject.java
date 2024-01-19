// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;


import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
	
	private double locationX; // X-coordinate of the object's location
	private double locationY; // Y-coordinate of the object's location
	private int rgb; // Color represented as an RGB value
	private int size; // Size of the object
	private Point location; // Point object to represent the location
	
	
	public GameObject() { //Constructor for the GameObject class
		
		// Initialize the X and Y coordinates of the location with random values
		this.setLocationX(getRandom(1000));
		this.setLocationY(getRandom(1000));
		
		// Create a Point object with rounded X and Y values
		float x = (float) (Math.round(getRandom(1000) * 10.0) / 10.0);
		float y = (float) (Math.round(getRandom(1000) * 10.0) / 10.0);
		
		location = new Point(x,y);
			
	}
	/**
	 * Method to return point location
	 * 
	 * @return location
	 */
	public Point getLocation() {
		
		return location;
	}
	/**
	 * Method to set x-coordinate
	 * 
	 * @param locX
	 */
	public void setLocationX(double locX) {
		
		locationX = locX;
		
	}
	/**
	 * Method to set y-coordinate
	 * 
	 * @param locY
	 */
	public void setLocationY(double locY) {
		
		locationY = locY;
		
	}
	/**
	 * Method to set Point location
	 * 
	 * @param loc
	 */
	public void setLocation(Point loc) {
		
		setLocationX((float) ((Math.round(loc.getX()) * 10.0) / 10.0));
		setLocationY((float) ((Math.round(loc.getY()) * 10.0) / 10.0));
	}
	/**
	 * Method to request x-location
	 * 
	 * @return locationX
	 */
	public double getLocationX() {
		
		return locationX;
	}
	/**
	 * Method to request y-location
	 * 
	 * @return locationY
	 */
	public double getLocationY() {
		
		return locationY;
	}
	/**
	 * Method to produce random number
	 * 
	 * @param num
	 * @return
	 */
	public int getRandom(int num) {
		
		Random random = new Random();
		return random.nextInt(num);
	}
	/**
	 * Method to request color
	 * 
	 * @return rgb
	 */
	public int getColor() {
		 
		return rgb;
	}
	/**
	 * Method to set rgb color
	 * 
	 * @param r
	 * @param g
	 * @param b
	 */
	public void setColor(int r, int g, int b) {
		
		this.rgb = ColorUtil.rgb(r, g, b);
		
	}
	/**
	 * Method to request size of object
	 * 
	 * @return size
	 */
	public int getSize() {
		
		return size;
	}
	
	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String value = 
				"Loc= " + getLocationX() + ", " + getLocationY()
				+ " Color= [" + ColorUtil.red(rgb) + "," + ColorUtil.green(rgb) + "," 
				+ ColorUtil.blue(rgb) + "]";
		
		return value;
	}
	public void setSize(int size) {
		this.size = size;
	}
	

}
