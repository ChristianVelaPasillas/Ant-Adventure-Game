package com.mycompany.a3;
//Necessary Imports
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BreakCommand extends Command {
	//Reference to GameWorld
	
	private GameWorld gw;
	//Break command
	
	public BreakCommand(GameWorld gw) {
		
		super("Break"); //Calls the parent class
		this.gw = gw; //Store reference to game world
		
	}
	//This method is triggered when the Break command is activated
	public void actionPerformed(ActionEvent e) {
		
		// Calls the decreaseSpeed method in GameWorld
		gw.decreaseSpeed();
		
	}

}