// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

public class FoodStation extends FixedGameObject { // Define a FoodStation class that extends the FixedGameObject class
	
	private int capacity; // Variable to store the capacity of the food station
	private int size; // Variable to store the size of the food station
	
	public FoodStation() { // Constructor for the FoodStation class
		
		setSize((25) + getRandom(5)); // Set the size of the food station to a random value between 25 and 30
		setColor(255, 255, 0); //Yellow
		size = getSize();
		setCapacity(size); // Set the capacity of the food station
		
	}
	

	/**
	 * Method to request capacity
	 * 
	 * @return capacity
	 */
	public int getCapacity() {
		
		return capacity;
	}
	/**
	 * Method to set capacity
	 * 
	 * @param cap
	 */
	public void setCapacity(int cap) {
		
		capacity = cap;
	}
	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString(); // Get the string representation of the parent class (FixedGameObject)
		String value = " size= " + getSize() + " capacity= " + capacity; // Additional food station attributes
		
		String concValue = "FoodStation: " + supString + value; // Concatenate the values to create the final string
		
		return concValue; // Return the string representation of the FoodStation
	}

}
