package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

//PositionCommand class extends Command
public class PositionCommand extends Command{
	
	private GameWorld gw;
	
	// Constructor for PositionCommand.
	public PositionCommand(GameWorld gw) {
		super("Position");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 // Checking if the game is currently paused.
		if (gw.getPause()) {
			// If the game is paused, enable the position-changing mode in the game world.
			gw.turnOnPosition();
		
		}
	}
}