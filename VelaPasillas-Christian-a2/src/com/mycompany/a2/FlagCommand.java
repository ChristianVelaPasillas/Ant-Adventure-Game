// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class FlagCommand extends Command {
	
	private GameWorld gw;
	
	public FlagCommand(GameWorld gw) {
		
		super("Collide with Flag");
		this.gw = gw;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Command cOk = new Command("Ok");  // Create "Ok" and "Cancel" commands for the dialog
		Command cCancel = new Command("Cancel");
		TextField myTF = new TextField();  // Create a text field for user input
		Command[] cmd = new Command[] {cOk, cCancel}; // Array of commands for the dialog
		
		Command c = Dialog.show("Enter Flag: ", myTF, cmd); // Show a dialog to enter a flag number
		if(c == cOk) { // If the user presses "Ok"
			String sCommand = myTF.getText().toString();
			if(sCommand.length() != 0)   // Check if the input is not empty
				switch(sCommand.charAt(0)) {  // Check the first character of the input
				
				case '1' :
					gw.flagCollision(1);
					break;
					
				case '2' :
					gw.flagCollision(2);
					break;
					
				case '3' :
					gw.flagCollision(3);
					break;
					
				case'4' :
					gw.flagCollision(4);
					break;
					
				default :
					System.out.println("Invalid Input!"); // Display an error message for invalid input
					break;
				}
		}
		
		else {
			System.out.println("No flag chosen!");
		}
	
	}


}