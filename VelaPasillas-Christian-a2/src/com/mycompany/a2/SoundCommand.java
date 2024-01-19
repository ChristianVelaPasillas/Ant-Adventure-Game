// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Toolbar;


public class SoundCommand extends Command{ // SoundCommand class represents a command for toggling sound in the game
	
	private CheckBox soundCheck; // The sound checkbox
	private GameWorld gw; // Reference to the GameWorld
	private Toolbar toolBar; // The application's toolbar
	
	public SoundCommand (GameWorld gw, CheckBox soundCheck, Toolbar myToolbar) { // Constructor for SoundCommand
		
		super("Sound"); // Command label
		this.gw = gw; // Initialize the GameWorld reference
		this.soundCheck = soundCheck; // Initialize the sound checkbox
		this.toolBar = myToolbar; // Initialize the toolbar
	}
	@Override
	public void actionPerformed(ActionEvent e) { // Action to be performed when the SoundCommand is invoked
		
		if(soundCheck.isSelected()) { // Check if the sound checkbox is selected (ON) or not (OFF)
			System.out.println("\nSound ON");
		}
		
		else {
			System.out.println("Sound OFF");
		}
		
		gw.setSound();  // Toggle the sound setting in the GameWorld
		toolBar.closeSideMenu(); // Close the side menu in the toolbar
		
	}
	

}