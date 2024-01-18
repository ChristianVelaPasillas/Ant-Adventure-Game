// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class Game extends Form { // I Define a class named Game that extends Form
	private GameWorld gameWo; // variable for the GameWorld
	
	public Game() {  // // This is the constructor for creating a Game object
		gameWo = new GameWorld(); // I created a new GameWorld and initialize it
		gameWo.init(); 
		play();    //Here I start the game
	}

	private void play() {  //This is a method to start the game

		Label myLabel= new Label ("Please enter a valid command: "); // I added a label to enter a command.
		this.addComponent(myLabel);
		final TextField myTextField = new TextField(); // I create a text field
		this.addComponent(myTextField);
		this.show(); // Show the form to the user
		
		myTextField.addActionListener(new ActionListener(){ // I Added an action listener to the text field
			
			public void actionPerformed(ActionEvent evt) {
				
			String sCommand = myTextField.getText().toString();
			myTextField.clear();
			if(sCommand.length() != 0)   // Check if the input command is not empty
				switch (sCommand.charAt(0)) {  // It process the user's command based on the first character
					case 'a':
						gameWo.accelerate(); //call to accelerate the speed of Ant
						System.out.print("\nThe Ant you own has accelerated.");
						break;
					case 'b':
						gameWo.brake(); // call to slow down the speed of Ant
						System.out.print("\nThe Ant you own has breaked.");
						break;
					case 'l':
						gameWo.turnLeft(); //call to say the degrees that the Ant turned to the left
						System.out.print("\nThe Ant you own has turned 5 degrees to the left.");
						break;
					case 'r':
						gameWo.turnRight(); //call to say the degrees that the Ant turned to the right
						System.out.print("\nThe Ant you own has turned 5 degrees to the right.");
						break;
					case 'c':
						gameWo.consumptionRate(); //call to say the food consumption rate
						System.out.print("\nThe Ant you own has set the food consumption rate.");
						break;
					case '1':
						System.out.print("\nThe Ant you own has reached Flag 1."); // The ant reached Flag 1
						gameWo.collideWithFlag(1);
						break;
					case '2':
						System.out.print("\nThe Ant you own has reached Flag 2."); // The ant reached Flag 
						gameWo.collideWithFlag(2);
						break;
					case '3':
						System.out.print("\nThe Ant you own has reached Flag 3."); // The ant reached Flag 3
						gameWo.collideWithFlag(3);
						break;
					case '4':
						System.out.print("\nThe Ant you own has reached Flag 4."); // The ant reached Flag 4
						gameWo.collideWithFlag(4);
						break;
					case '5':
						System.out.print("\nThe Ant you own has reached Flag 5."); // The ant reached Flag 5
						gameWo.collideWithFlag(5);
						break;
					case '6':
						System.out.print("\nThe Ant you own has reached Flag 6."); // The ant reached Flag 6
						gameWo.collideWithFlag(6);
						break;
					case '7':
						System.out.print("\nThe Ant you own has reached Flag 7."); // The ant reached Flag 7
						gameWo.collideWithFlag(7);
						break;
					case '8':
						System.out.print("\nThe Ant you own has reached Flag 8."); // The ant reached Flag 8
						gameWo.collideWithFlag(8);
						break;
					case '9':
						System.out.print("\nThe Ant you own has reached Flag 9."); // The ant reached Flag 9
						gameWo.collideWithFlag(9);
						break;
					case 'f':
						System.out.print("\nThe Ant you own has collided with the food station."); // The ant has collided with the food station
						gameWo.collideWithFoodStation();
						break;
					case 'g':
						System.out.print("\nThe Ant you own has collided with the spider."); // The ant has collided with the spider
						gameWo.collideWithSpider();
						break;
					case 't':
						System.out.print("\nThe Clock has ticked."); // Clock has ticked
						gameWo.tickClock();
						break;
					case 'd':
						System.out.print("\nI am currently showing current game and Ant state values\n"); // Current game and state values
						gameWo.display();
						break;
					case 'm':
						System.out.print("\nI am currently showing current map\n"); // Current map
						gameWo.outputMap();
						break;
					case 'y':
						System.out.print("\nSuccesfully, You have exit the game \nThank you for being part of the ant game.\n"); // You have exit the game.
						System.exit(0);
						break;
					case 'n':
						System.out.print("\nYou have clicked on the option NO. \nSo, let's continue with the ant game, keep enjoying the game!!!.\n"); // Enjoy the game
						break;
					case 'x':
						gameWo.exit();
						break;
					default: 
						System.out.print("\nThis input did not exist. Please try again, with a different keyboard letter.");
						break;
					//add code to handle rest of the commands
				} //End of the Switch
			} // End actionPerformed
		}); //addActionListener
	    } //  End of play
}
