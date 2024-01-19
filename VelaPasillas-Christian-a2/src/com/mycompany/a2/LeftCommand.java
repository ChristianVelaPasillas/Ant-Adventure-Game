// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LeftCommand extends Command { // Define a LeftCommand class that extends the Command class
	
	private GameWorld gw;
	
	// Constructor for the LeftCommand
	public LeftCommand(GameWorld gw) {
		
		super("Left"); // Set the command label to "Left"
		this.gw = gw; // Set the GameWorld reference
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// Call the changeDirection method in GameWorld to change the direction to left
		gw.changeDirection('l');
		
	}

}