// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class LeftCommand extends Command{
	private GameWorld gw;
	
	public LeftCommand(GameWorld gw) {
		super("Left");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.turnLeft();		
		
		//Dialog.show("Left", "Turning Left!", new Command("Continue"));
		System.out.println("Turning left!");
		
		gw.notifyObservers(gw.getObjects());
	}
}
