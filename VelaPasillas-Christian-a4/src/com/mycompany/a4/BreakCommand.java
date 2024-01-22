// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class BreakCommand extends Command {
	private GameWorld gw;
	
	public BreakCommand(GameWorld gw) {
		super("Brake");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		gw.brake();
		
		//Dialog.show("Brake", "Now braking!", new Command("Continue"));
		System.out.println("Now braking");
		
		gw.notifyObservers(gw.getObjects());
	}
}
