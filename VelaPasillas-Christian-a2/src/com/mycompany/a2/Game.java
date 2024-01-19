// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class Game extends Form {
	
	private GameWorld gw; // Reference to the game world
	private ScoreView sv; // Score view
	private MapView mv; // Map view
	private static String gameTitle = "The Journey Game";

	
	public Game() { // Initialize game objects and views
		
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);
		gw.setGameWorldHeight(mv.getMapHeight());
		gw.setGameWorldWidth(mv.getMapWidth());
		
		this.setLayout(new BorderLayout()); // Set up the layout and add components to the form
		this.setScrollable(false);
		
		this.addComponent(BorderLayout.CENTER, mv); // MapView in the center
		this.addComponent(BorderLayout.NORTH, sv); // ScoreView at the top
		 
		createTB(); // Create the toolbar
		createCommands();  // Create button commands

		
		this.show(); // Show the form
		gw.init(); // Initialize the game world
	}
	//Method to create tool bar
	public void createTB() {
		
		Toolbar myToolbar = new Toolbar();
		this.setToolbar(myToolbar);
		myToolbar.setTitle(gameTitle);
		
		AccelCommand accelCommand = new AccelCommand(gw); // Add commands and buttons to the side menu
		myToolbar.addCommandToSideMenu(accelCommand);
		Button accelButton = new Button("Accelerate");
		accelButton.setCommand(accelCommand);
		addKeyListener('a', accelCommand); //This is for button
		
		CheckBox soundOn = new CheckBox("Sound");
		soundOn.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundOn.getAllStyles().setBgTransparency(255);
		SoundCommand soundCommand = new SoundCommand(gw, soundOn, myToolbar);
		soundOn.setCommand(soundCommand);
		myToolbar.addComponentToSideMenu(soundOn);
		
		AboutCommand abtCommand = new AboutCommand();
		myToolbar.addCommandToSideMenu(abtCommand);
		
		ExitCommand exitCommand = new ExitCommand();
		myToolbar.addCommandToSideMenu(exitCommand);
		
		HelpCommand helpCommand = new HelpCommand();
		myToolbar.addCommandToRightBar(helpCommand);
	
	}
	//Method to create button commands
	public void createCommands() {
		
		Container myContainerLeft = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Container myContainerRight = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Container myContainerBottom = new Container(new FlowLayout(Component.CENTER));
	
		//Left container commands
		AccelCommand accelCommand = new AccelCommand(gw);
		Button accelButton = new ButtonObj(accelCommand);
		accelButton.getAllStyles().setMarginTop(100);
		addKeyListener('a', accelCommand);
		myContainerLeft.add(accelButton);
		
		LeftCommand leftCommand = new LeftCommand(gw);
		Button leftButton = new ButtonObj(leftCommand);
		addKeyListener('l', leftCommand);
		myContainerLeft.add(leftButton);
		
		myContainerLeft.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.rgb(0, 0, 0)));
		this.addComponent(BorderLayout.WEST, myContainerLeft);
		
		//Right container commands
		BrakeCommand brakeCommand = new BrakeCommand(gw);
		Button brakeButton = new ButtonObj(brakeCommand);
		brakeButton.getAllStyles().setMarginTop(100);
		addKeyListener('b', brakeCommand);
		myContainerRight.add(brakeButton);
		
		RightCommand rightCommand = new RightCommand(gw);
		Button rightButton = new ButtonObj(rightCommand);
		addKeyListener('r', rightCommand);
		myContainerRight.add(rightButton);
		
		myContainerRight.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.rgb(0, 0, 0)));
		this.addComponent(BorderLayout.EAST, myContainerRight);
		
		//Bottom container commands
		FlagCommand flagCommand = new FlagCommand(gw);
		Button flagButton = new ButtonObj(flagCommand);
		myContainerBottom.add(flagButton);
		
		SpiderCommand spiderCommand = new SpiderCommand(gw);
		Button spiderButton = new ButtonObj(spiderCommand);
		addKeyListener('g', spiderCommand);
		myContainerBottom.add(spiderButton);
		
		FoodCommand foodCommand = new FoodCommand(gw);
		Button foodButton = new ButtonObj(foodCommand);
		addKeyListener('f', foodCommand);
		myContainerBottom.add(foodButton);
	
		FoodCommand11 foodCommand11 = new FoodCommand11(gw);
		addKeyListener('c', foodCommand11);

		
		TickCommand tickCommand = new TickCommand(gw);
		Button tickButton = new ButtonObj(tickCommand);
		addKeyListener('t', tickCommand);
		myContainerBottom.add(tickButton);
		
		myContainerBottom.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.rgb(0, 0, 0)));
		this.add(BorderLayout.SOUTH, myContainerBottom);
	}

}
