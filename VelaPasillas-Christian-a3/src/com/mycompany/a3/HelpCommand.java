package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

//HelpCommand class extends Command, specifically for handling 'Help' actions.
public class HelpCommand extends Command {
	
	public HelpCommand() { // Constructor for HelpCommand.
		
		super("Help");
	}
	 // This method is triggered when the Help command is activate
	public void actionPerformed(ActionEvent e) {
		
		String help = "Game Commands: \n"
				+ "A - Accelerate \n "
				+ "B - Brake \n" 
				+ "L - Turn Left \n" 
				+ "R - Turn Right \n";
				
		
		Dialog.show("Help", help, "Exit", null);
	}

}