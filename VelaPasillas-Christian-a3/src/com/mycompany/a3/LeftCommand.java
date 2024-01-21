package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

//LeftCommand class extends Command
public class LeftCommand extends Command {
	
	private GameWorld gw;
	
	
	public LeftCommand(GameWorld gw) { // Constructor for LeftCommand.
		
		super("Left"); // Calling the parent class (Command) constructor
		this.gw = gw; // Storing the reference to the GameWorld
		
	}
	public void actionPerformed(ActionEvent e) {
		// Calls the changeDirectionLeft method in GameWorld 
		gw.changeDirectionLeft();
		
	}

}