// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {
	
	public AboutCommand() {
		super("About");
	}
	
	public void actionPerformed(ActionEvent ev) {
		String content = "Christian Vela Pasillas\n" + "CSC 133\n";		
		Dialog.show("About", content, new Command("Continue"));
	}

}
