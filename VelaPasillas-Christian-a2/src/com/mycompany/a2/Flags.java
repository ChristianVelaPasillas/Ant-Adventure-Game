// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

public class Flags extends FixedGameObject{
	
	private int flagNum;
	private int flagSize;

	// Constructor for the Flags class
	public Flags() {
		
		flagNum = getObjectNumber(); // Get a unique sequence number for the flag
		flagSize = 10; // Set the flag's size to 10
		setColor(0, 204, 0); //Color Green
		
	}

	/**
	 * Method to override toString
	 */
	public String toString() {
		// Get the string representation of the parent class (FixedGameObject)
		String supString = super.toString();
		String value = " size= " + flagSize + " seqNum= " + flagNum; // Additional flag attributes
		
		String concValue = "Flag:   " + supString + value; // Concatenate the values to create the final string
		
		return concValue; // Return the string representation of the flag
	}

}

