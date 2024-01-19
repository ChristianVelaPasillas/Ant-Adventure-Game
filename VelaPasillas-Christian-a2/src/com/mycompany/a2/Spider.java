// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

public class Spider extends MovableGameObject { // Constructor for creating a Spider object

	public Spider() {
		
		setSize(20 + getRandom((10))); // Set the size of the spider
		setColor(0, 0, 0); //Black color

	}

	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString(); // Get the superclass object's string representation
		String value = " size= " + getSize(); // Get the size of the spider
		
		String concValue = "Spider: " + supString + value;   // Combine the superclass string and size to form the full description of the Spider
		
		return concValue;
	}

}
