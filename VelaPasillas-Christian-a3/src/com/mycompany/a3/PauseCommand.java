package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PauseCommand extends Command{
	
	private Game game; // A reference to the Game object
	
	 // Constructor for PauseCommand.
	public PauseCommand(Game gme) {
		
		super("Pause"); // Calling the parent class 
		this.game = gme; // Storing the reference to the Game instance for late
	
	}
	 
	public void actionPerformed(ActionEvent e) {
		// Calls the pauseGame method in the Game class to toggle the game's pause state.
		game.pauseGame();
	}
}