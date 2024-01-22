// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class AccelerateCommand extends Command{
	private GameWorld gw;
	
	public AccelerateCommand(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {		
		gw.accelerate();
		
		//Dialog.show("Accelerate", "Now accelerating!", new Command("Continue"));
		System.out.println("Now accelerating!");
		
		gw.notifyObservers(gw.getObjects());
	}

}
