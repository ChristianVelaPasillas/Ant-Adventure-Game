// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SpiderCommand extends Command {
	
	private GameWorld gw;   // Reference to the GameWorld
	
	public SpiderCommand(GameWorld gw) { // Constructor for SpiderCommand
		
		super("Collide with Spider"); // Command label
		this.gw = gw; // Initialize the GameWorld reference
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {  // Action to be performed when the SpiderCommand is invoked
		
		gw.spiderCollision(); // Call the spiderCollision method in GameWorld
		
	}

}
