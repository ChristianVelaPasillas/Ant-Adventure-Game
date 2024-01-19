// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FoodCommand extends Command { // Define a FoodCommand class that extends the Command class
	
	private GameWorld gw; // Reference to the GameWorld
	
	public FoodCommand(GameWorld gw) { // Constructor for FoodCommand that takes a GameWorld instance as a parameter
		
		super("Collide with Food Station");
		this.gw = gw; // Initialize the GameWorld reference
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		gw.foodCollision();  // Call the foodCollision method in the GameWorld
		
	}

}
