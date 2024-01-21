package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AccelCommand extends Command {
	
	private GameWorld gw;
	
	public AccelCommand(GameWorld gw) { // This is our constructor
		
		super("Accelerate"); // Interacting with our game world
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(!gw.getPause()) { // Check if game is not paused
			
			gw.increaseSpeed(); //Increase the speed
		}
		else {
			
			gw.setPause(true); //We makes sure that the game is paused
		}
	}

}