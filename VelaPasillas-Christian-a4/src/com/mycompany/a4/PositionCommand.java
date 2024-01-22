// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class PositionCommand extends Command {
	
	private GameWorld gw;
	
	public PositionCommand(GameWorld gw) {
		super("Position");
		this.gw = gw;
	}
	
	@Override
	public  void actionPerformed(ActionEvent e) {
		gw.setPressed(true);
	}
}
