package com.mycompany.a3;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Toolbar;


public class SoundCommand extends Command{
	
	private CheckBox soundCheck; // CheckBox to represent the sound
	private GameWorld gw; // Reference to the GameWorld
	private Toolbar toolBar; // Toolbar to interact with the toolbar
	
	public SoundCommand (GameWorld gw, CheckBox soundCheck, Toolbar myToolbar) {
		
		super("Sound"); // Calling the parent class
		this.gw = gw; // Storing the reference to the GameWorld instance.
		this.soundCheck = soundCheck; // Storing the reference to the CheckBox for sound.
		this.toolBar = myToolbar; // Storing the reference to the Toolbar.
	}
	 // This method is triggered when the Sound command is activated
	public void actionPerformed(ActionEvent e) {
		
		// Checking the state of the soundCheck CheckBox
		if(soundCheck.isSelected()) {
			System.out.println("\nSound ON");
		
		}
		
		else {
			System.out.println("Sound OFF");
			
		}
		
		gw.setSound();  // Toggling the sound setting in the GameWorld.
		toolBar.closeSideMenu(); // Closing the side menu of the toolbar
		
	}
	

}