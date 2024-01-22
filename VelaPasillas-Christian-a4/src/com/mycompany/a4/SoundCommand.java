// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class SoundCommand extends Command{
	private GameWorld gw;
	private CheckBox cb;
	
	public SoundCommand(GameWorld gw, CheckBox cb) {
		super("Sound");
		this.gw = gw;
		this.cb = cb;
	}
	
	public void actionPerformed(ActionEvent ev) {
		if (cb.isSelected()) {
			cb.getAllStyles().setBgTransparency(255);
			gw.setSound(true);
			gw.notifyObservers(gw.getObjects());
		} else {
			cb.getAllStyles().setBgTransparency(125);
			gw.setSound(false);
			gw.notifyObservers(gw.getObjects());
		}
	}
}
