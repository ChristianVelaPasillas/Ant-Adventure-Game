// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

public abstract class FixedGameObject extends GameObject{
	
	private static int objectNum; // Static variable to keep track of the object number
	private int size; // Size of the fixed game object
	
	/**
	 * Method provide sequence number
	 * 
	 * @return objectNum
	 */
	public int getObjectNumber() {
		
		objectNum++; // Increment the object number
		return objectNum; // Return the updated object number
	}
	
	public void setSize(int i) {
		
		size = i; // Set the size of the object
	}
	
	public int getSize() {
		
		return size; // Return the size of the object
	}

}