// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;

public class ButtonObj extends Button{
	public ButtonObj(Command cmd)
	{
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.BLUE);
		this.getAllStyles().setFgColor(ColorUtil.WHITE);
		this.getAllStyles().setPadding(Component.TOP, 5);
		this.getAllStyles().setPadding(Component.BOTTOM, 5);
	}
}