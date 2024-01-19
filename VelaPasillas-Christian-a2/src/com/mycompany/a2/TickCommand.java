// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command {
	
	private GameWorld gw;
	
	public TickCommand(GameWorld gw) { // Constructor for TickCommand
		
		super("Tick");
		this.gw = gw;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) { // Action performed when the TickCommand is invoked
		
		gw.clockTick();
		
	}

}