// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class CollideWithFoodStationCommand extends Command {
	private GameWorld gw;
	
	public CollideWithFoodStationCommand(GameWorld gw) {
		super("Collide with Food Stations");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent ev) {
		//gw.foodStationCollision();
		
		Dialog.show("FoodStation", "Collided with food station!", new Command("Continue"));
		System.out.println("Collided with food station!");
		
		gw.notifyObservers(gw.getObjects());
	}
}
