// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command{
	public HelpCommand() {
		super("Help");
	}
	
	public void actionPerformed(ActionEvent ev) {
		String content = "Accelerate: 'a'\nBrake: 'b'\nTurn Left: 'l'\nTurn Right: 'r'\n"
				+ "Pause Game: 'p'\nPosition: 'o'\n Set food consumption rate: 'c'\n Exit: 'x'";
				
		Dialog.show("Help", content, new Command("Continue"));
	}
}
