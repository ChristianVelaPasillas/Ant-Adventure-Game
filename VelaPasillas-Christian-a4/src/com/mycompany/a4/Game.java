// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Toolbar;


public class Game extends Form implements Runnable{
	
	private GameWorld gw;
	private MapView mv;		
	private ScoreView sv;	
	private UITimer timer = new UITimer(this);;
	
	//Containers
	private Container leftAreaContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	private Container rightAreaContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	private Container bottomAreaContainer = new Container(new FlowLayout(Component.CENTER));
	
	//Tool bar
	Toolbar sideMenu = new Toolbar();
	
	//Command Buttons
	private ButtonObj accelerateBtn, brakeBtn, turnLeftBtn, turnRightBtn, positionBtn, pauseBtn;
	
	//Commands
	private AccelerateCommand accelerateCmd;
	private BreakCommand brakeCmd;
	private LeftCommand turnLeftCmd;
	private RightCommand turnRightCmd;
	private PositionCommand positionCmd;
	private PauseCommand pauseCmd;
		
	public Game() {
		gw = new GameWorld();	//create "Observable" GameWorld
		mv = new MapView();		//create an "Observer for the map
		sv = new ScoreView();	//create an "Observer" for the game/ant state data
		
		gw.addObserver(mv);		//register the map observer
		gw.addObserver(sv);		//register the score observer
		
		
		this.setLayout(new BorderLayout());
		//gw.init();	//initialize world
		
		sideMenu();
		
		leftAreaContainer();
		rightAreaContainer();
		
		bottomAreaContainer();
		
		add(BorderLayout.CENTER, mv);
		add(BorderLayout.NORTH, sv);
		
		gw.notifyObservers(gw.getObjects());
		//timer = new UITimer(this);
		this.show();
		
		gw.setMapHeight(mv.getMapHeight()/2);
		gw.setMapWidth(mv.getMapWidth()/2);
		gw.init();	//initialize world
		
		gw.createSounds();
		gameStatus();
		revalidate();
	}
	
	/**
	 * When an object implementing interface Runnable is used to create a thread,
	 * starting the thread causes the object's run method to be called
	 * in that separately executing thread.
	 */
	@Override
	public void run() {
		Dimension dCmpSize = new Dimension(mv.getWidth(), mv.getHeight());
		
		gw.worldTick(100, dCmpSize);
		gw.notifyObservers();
	}
	
	public boolean getPaused() {
		return gw.getPaused();
	}
	
	public void gameStatus() {
		if(gw.getPaused() && timer != null) {
				
			timer.cancel();	
				
			gw.getBackground().pause();
			pauseBtn.setText("Play");
			gw.setPaused(true);
				
			disableButtons();
			removeListeners();
			enablePosBtn();
		} else {		
			//Schedule(int timeMillis, boolean repeat, Form bound)
			//Binds the timer to start at the given schedule
			timer.schedule(10, true, this);
			  
			pauseBtn.setText("Pause"); 
			gw.setPaused(false); 
			 
			addListeners();
			enableButtons();
			disablePosBtn();
		}
	}
	
	public void disableButtons() {
		//disable all buttons 
		accelerateBtn.setEnabled(false);
		brakeBtn.setEnabled(false);
		turnLeftBtn.setEnabled(false);
		turnRightBtn.setEnabled(false);
		accelerateCmd.setEnabled(false);
	}
	
	public void enableButtons() {
		accelerateBtn.setEnabled(true); 
		brakeBtn.setEnabled(true);
		turnLeftBtn.setEnabled(true); 
		turnRightBtn.setEnabled(true);
		accelerateCmd.setEnabled(true);
	}
	
	public void removeListeners() {
		//remove all key listeners for buttons
		removeKeyListener('a', accelerateCmd);
		removeKeyListener('b', brakeCmd);
		removeKeyListener('l', turnLeftCmd);
		removeKeyListener('r', turnRightCmd);
	}
	
	public void addListeners() {
		addKeyListener('a', accelerateCmd); 
		addKeyListener('b', brakeCmd);
		addKeyListener('l', turnLeftCmd); 
		addKeyListener('r', turnRightCmd);
		  
	}
	
	public void enablePosBtn() {
		//position button it enabled
		positionBtn.setEnabled(true);
		positionCmd.setEnabled(true);
		positionBtn.getAllStyles().setBgColor(ColorUtil.BLUE);
		positionBtn.getAllStyles().setFgColor(ColorUtil.WHITE);
		addKeyListener('o', positionCmd);
	}
	
	public void disablePosBtn() {
		positionBtn.getDisabledStyle();
		positionBtn.setEnabled(false); 
		positionCmd.setEnabled(false);
		positionBtn.getAllStyles().setBgColor(ColorUtil.WHITE);
		positionBtn.getAllStyles().setFgColor(ColorUtil.BLUE);
	}
	
	/**
	 * This method will set the side menu
	 * The side menu will contain:
	 * - Accelerate
	 * - Sound
	 * - About
	 * - Exit
	 */
	private void sideMenu() {
		setToolbar(sideMenu);
		sideMenu.setTitle(" The Journey Game ");
		
		/* 
		 * Accelerate menu item
		 * - Should invoke 'a' command
		 */
		accelerateCmd = new AccelerateCommand(this.gw);
		sideMenu.addCommandToSideMenu(accelerateCmd);
		
		/* 
		 * Sound menu item 
		 * - Includes a check box showing current state of "sound" attribute
		 * - Selecting sound menu item check box sets a boolean "sound"
		 *		attribute to "ON" or "OFF" accordingly
		 * - When the game starts sound attribute should be "OFF"
		 */
		soundCmdBtn();
		
		/* 
		 * About menu item
		 * - displays a dialog box with 
		 * 	+ personal name
		 * 	+ course name
		 * 	+ any other info like version number of program
		 */
		AboutCommand about = new AboutCommand();
		sideMenu.addCommandToSideMenu(about);
		
		/*
		 * Exit menu item
		 * - invokes 'x' command
		 * - dialog box to prompt graphically for confirmation
		 * 		and then exit the program
		 */
		ExitCommand exit = new ExitCommand(this.gw);
		sideMenu.addCommandToSideMenu(exit);
		
		/*
		 * Help command
		 * - displays dialog box of all key commands
		 */
		HelpCommand help = new HelpCommand();
		sideMenu.addCommandToRightBar(help);

		mv.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.rgb(255, 0, 0)));

	}
	
	/**
	 * This method will have the bottom area of commands
	 * This includes:
	 * - Collide with Flag
	 * - Collide with Spider
	 * - Collide with Food Stations
	 * - Tick
	 */
	private void bottomAreaContainer() {
		setLayout(new BorderLayout());
		bottomAreaContainer.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		this.addComponent(BorderLayout.SOUTH, bottomAreaContainer);
		
		//position command button 
		positionCmdBtn();
		
		//pause command button
		pauseCmdBtn();

		
	}
	
	/**
	 * This method will have the left area of commands
	 * This includes:
	 * - Accelerate
	 * - Left
	 */
	private void leftAreaContainer() {
		leftAreaContainer.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		this.addComponent(BorderLayout.WEST, leftAreaContainer);
		//Accelerate command Button
		accelerateCmdBtn();

		//Turn Left command Button
		turnLeftCmdBtn();
	}
	
	/**
	 * This method will have the right area of commands
	 * This includes:
	 * - Brake
	 * - Right
	 */
	private void rightAreaContainer() {
		rightAreaContainer.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		this.addComponent(BorderLayout.EAST, rightAreaContainer);
		
		//Brake command Button
		brakeCmdBtn();

		//Turn Right command Button
		turnRightCmdBtn();
	}
	
	
	//Command buttons
	
	//create position command button
	private void positionCmdBtn() {
		positionCmd = new PositionCommand(gw);
		positionBtn = new ButtonObj(positionCmd);
		positionBtn.setCommand(positionCmd);		
		//positionBtn.getAllStyles().setMargin(Component.TOP, 250);
		positionBtn.getAllStyles().setBorder(Border.createLineBorder(6, ColorUtil.BLACK));
		//if(gw.getPaused()) { enablePosBtn(); } else { disablePosBtn(); }
		
		bottomAreaContainer.addComponent(positionBtn);
		
	}
	
	//create pause command button
	private void pauseCmdBtn() {
		pauseCmd = new PauseCommand(gw, this);
		pauseBtn = new ButtonObj(pauseCmd);
		pauseBtn.setCommand(pauseCmd);
		
		addKeyListener('p', pauseCmd);
		
		pauseBtn.getAllStyles().setBorder(Border.createLineBorder(6, ColorUtil.BLACK));
		pauseBtn.setText("Play");
		gw.setPaused(true);
		
		bottomAreaContainer.addComponent(pauseBtn);
	}
	
	//Create accelerate command button
	private void accelerateCmdBtn() {
		accelerateCmd = new AccelerateCommand(gw);
		accelerateBtn = new ButtonObj(accelerateCmd);
		accelerateBtn.setCommand(accelerateCmd);
		
		addKeyListener('a', accelerateCmd);
		
		
		accelerateBtn.getAllStyles().setMargin(Component.TOP, 250);
		accelerateBtn.getAllStyles().setBorder(Border.createLineBorder(6, ColorUtil.BLACK));
		
		
		leftAreaContainer.add(accelerateBtn);
	}
	
	//create brake command button
	private void brakeCmdBtn() {
		brakeCmd = new BreakCommand(gw);
		brakeBtn = new ButtonObj(brakeCmd);
		brakeBtn.setCommand(brakeCmd);
		
		addKeyListener('b', brakeCmd);
		
		brakeBtn.getAllStyles().setMargin(Component.TOP, 250);
		brakeBtn.getAllStyles().setBorder(Border.createLineBorder(6, ColorUtil.BLACK));
		
		rightAreaContainer.add(brakeBtn);
	}
	
	
	//Sound command button
	private void soundCmdBtn() {
		CheckBox checkSound = new CheckBox("Sound");
		SoundCommand sound = new SoundCommand(this.gw, checkSound);
		
		checkSound.setCommand(sound);
		checkSound.getAllStyles().setBgTransparency(125);
		checkSound.getAllStyles().setFgColor(ColorUtil.WHITE);
		checkSound.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		
		sideMenu.addComponentToSideMenu(checkSound);
	}
	
	
	//create turn left command button
	private void turnLeftCmdBtn() {
		turnLeftCmd = new LeftCommand(gw);
		turnLeftBtn = new ButtonObj(turnLeftCmd);
		turnLeftBtn.setCommand(turnLeftCmd);
		
		addKeyListener('l', turnLeftCmd);
		
		turnLeftBtn.getAllStyles().setBorder(Border.createLineBorder(6, ColorUtil.BLACK));
		
		leftAreaContainer.add(turnLeftBtn);
	}
	
	//create turn right command button
	private void turnRightCmdBtn() {
		turnRightCmd = new RightCommand(gw);
		turnRightBtn = new ButtonObj(turnRightCmd);
		turnRightBtn.setCommand(turnRightCmd);
		
		addKeyListener('r', turnRightCmd);
		
		turnRightBtn.getAllStyles().setBorder(Border.createLineBorder(6, ColorUtil.BLACK));
		
		rightAreaContainer.add(turnRightBtn);
	}

}
