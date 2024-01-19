// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BrakeCommand extends Command { // I defined a BrakeCommand class that extends the Command class
	
	private GameWorld gw; // Reference to the GameWorld
	
	public BrakeCommand(GameWorld gw) {
		
		super("Brake"); // Here, I set the label of the command button
		this.gw = gw; // Here, I initialize the GameWorld reference
		
	}
	@Override
	public void actionPerformed(ActionEvent e) { // I Called the changeSpeed method in the GameWorld with the 'b' argument
		
		gw.changeSpeed('b');
		
	}

}
