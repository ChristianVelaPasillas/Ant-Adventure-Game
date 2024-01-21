package com.mycompany.a3;

import com.codename1.ui.Command; // Import Statements
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command{
	
	public AboutCommand() { // This is a Method to handle action events
		
		super("About");
	}

	public void actionPerformed(ActionEvent e) {
	
		String abt = "Christian Vela Pasillas\nCSC 133\nThe Journey Game v.3";
		Dialog.show("About", abt, "Exit", null);
	
	}
}