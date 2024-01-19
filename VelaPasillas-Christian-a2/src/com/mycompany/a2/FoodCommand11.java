// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FoodCommand11 extends Command { // Define a FoodCommand11 class that extends the Command class
	
	private GameWorld gw; // Reference to the GameWorld
	
	public FoodCommand11(GameWorld gw) {  // Constructor for FoodCommand11 that takes a GameWorld instance as a parameter
		
		super("Colide with FoodCommand11"); // Set the label of the command button
		this.gw = gw; // Initialize the GameWorld reference
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		gw.foodCollision11(); // Call the foodCollision11 method in the GameWorld 
		
	}

}
