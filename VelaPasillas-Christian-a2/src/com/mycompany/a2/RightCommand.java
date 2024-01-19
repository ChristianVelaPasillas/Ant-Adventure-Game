// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RightCommand extends Command { // Define a RightCommand class that extends the Command class
	
	private GameWorld gw; // Reference to the GameWorld
	
	// Constructor for the RightCommand
	public RightCommand(GameWorld gw) {
		
		super("Right");
		this.gw = gw;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 // Call the changeDirection method in GameWorld to change the direction to right
		gw.changeDirection('r');
		
	}

}