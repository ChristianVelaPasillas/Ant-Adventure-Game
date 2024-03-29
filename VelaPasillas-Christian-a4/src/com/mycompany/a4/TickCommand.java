// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class TickCommand extends Command{
	private GameWorld gw;
	
	public TickCommand(GameWorld gw) {
		super("Tick");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		//gw.worldTick();
		
		Dialog.show("Tick", "The world ticked!", new Command("Continue"));
		System.out.println("The world ticked!");
		
		gw.notifyObservers(gw.getObjects());
	}
}
