package com.mycompany.a3;

//Import class
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

//ExitCommand class extends Command
public class ExitCommand extends Command {
	
	// Constructor for ExitCommand
	public ExitCommand() {
		
		super("Exit");
	}
	// This method is triggered when the Exit command is activated.
	public void actionPerformed(ActionEvent e) {
		
		if(Dialog.show("Exit", "Do you want to exit the game?", "Yes", "No")) {
			System.exit(0);
		}
		
	}

}