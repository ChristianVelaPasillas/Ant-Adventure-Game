// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class ExitCommand extends Command{
	private GameWorld gw;
	
	public ExitCommand(GameWorld gw) {
		super("Exit");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {	
		if(!Dialog.show("Exit","Would you like to exit the game?", "No", "Yes")) {
			gw.gameExit(true);
		}
		
		gw.notifyObservers(gw.getObjects());
	}
}
