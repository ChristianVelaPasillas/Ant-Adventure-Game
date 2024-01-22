// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class RightCommand extends Command{
	private GameWorld gw;
	
	public RightCommand(GameWorld gw) {
		super("Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.turnRight();
		
		//Dialog.show("Right", "Turning right!", new Command("Continue"));
		System.out.println("Turning right!");
		
		gw.notifyObservers(gw.getObjects());
	}
}