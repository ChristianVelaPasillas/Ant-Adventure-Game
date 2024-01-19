// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {
	
	public ExitCommand() { // Constructor for ExitCommand
		
		super("Exit"); // Set the label of the command button to "Exit"
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(Dialog.show("Exit", "Do you want to exit the game?", "Yes", "No")) {  // Show a confirmation dialog to confirm whether the user wants to exit the game
			System.exit(0);  // If the user chooses "Yes," exit the application
		}
		
	}

}