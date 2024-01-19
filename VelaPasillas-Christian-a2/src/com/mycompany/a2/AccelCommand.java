// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AccelCommand extends Command {
	
	private GameWorld gw; // I Declare a reference to the GameWorld class
	
	public AccelCommand(GameWorld gw) { // This is the Constructor for AccelCommand
		
		super("Accelerate"); // I Called the constructor of the Command class
		this.gw = gw; // Here I Initialize the gw reference with the provided GameWorld instance
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		gw.changeSpeed('a'); // Here I called the changeSpeed method of the GameWorld
		
	}

}
