// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.Border;

public class ButtonObj extends Button {
	
	public ButtonObj(Command com) {
		
		// Set background transparency to 255 (fully opaque)
		this.getAllStyles().setBgTransparency(255);
		// Create a 3-pixel black border around the button
		this.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.rgb(0, 0, 0)));
		// Add 3 pixels of padding to the top and bottom of the button
		this.getAllStyles().setPadding(TOP, 3);
		this.getAllStyles().setPadding(BOTTOM, 3);
		// Set the background color of the unselected style to blue
		this.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		// Set the foreground (text) color of the unselected style to white
		this.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		// Set background transparency to 125 and background color when the button is pressed
		this.getPressedStyle().setBgTransparency(125);
		this.getPressedStyle().setBgColor(ColorUtil.rgb(0, 100, 100));
		// Set the foreground (text) color when the button is pressed to black
		this.getPressedStyle().setFgColor(ColorUtil.BLACK);
		// Set the Command associated with this button
		this.setCommand(com);
	}

}