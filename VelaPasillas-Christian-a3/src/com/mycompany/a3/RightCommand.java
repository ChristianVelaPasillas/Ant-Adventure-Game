package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RightCommand extends Command {
	
	private GameWorld gw;
	
	public RightCommand(GameWorld gw) { // Constructor for RightCommand.
		
		super("Right"); // Calling the parent class
		this.gw = gw; // Storing the reference to the GameWorld
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// Calls the changeDirectionRight method in GameWorld 
		gw.changeDirectionRight();
		
	}

}