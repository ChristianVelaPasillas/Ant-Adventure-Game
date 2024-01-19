// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;


import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

//Define a HelpCommand class that extends the Command class
public class HelpCommand extends Command {
	
	public HelpCommand() {
		
		super("Help");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// Create a help message with game commands
		String help = "Game Commands: \n"
				+ "A - Accelerate \n "
				+ "B - Brake \n" 
				+ "L - Turn Left \n" 
				+ "R - Turn Right \n" 
				+ "F - Collide with Food Station \n" 
				+ "G - Collide with Spider \n"
				+ "T - Clock Tick \n"
				+ "C - Set food consumption rate \n";
		
		Dialog.show("Help", help, "Exit", null); // Display the help message in a dialog box
	}

}
