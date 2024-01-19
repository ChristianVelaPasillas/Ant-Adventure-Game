// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command{
	
	public AboutCommand() { // Constructor for AboutCommand
		
		super("About");
	}
	@Override // This method is called when the "About" command is invoked
	public void actionPerformed(ActionEvent e) { 
		
		String abt = "Christian Vela Pasillas\nClass: CSC 133\nThe Journey Game";
		Dialog.show("About", abt, "Exit", null); // Here, I Showed the About message in a dialog with an "Exit" button
	
	}
}