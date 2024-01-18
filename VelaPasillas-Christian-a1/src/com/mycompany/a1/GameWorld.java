// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Random;

public class GameWorld { // This are the constants for the game's width and height
	private static final float WIDTH = 1000;
	private static final float HEIGHT = 1000;
	private Random randomGenerator = new Random(); // Here we are using the random number generator for various game elements
	private ArrayList<GameObject> gameObjects; // This is the arrayList to store game objects
	 
	// This are the game attributes
	private int lives = 3;
	private int clock = 0;
	
	//Number of the Flags 
	Flags flag1;
	Flags flag2;
	Flags flag3;
	Flags flag4;
	Flags flag5;
	
	//Numbers of the Spiders
	Spider spider1;
	Spider spider2;
	Spider spider3;
	
	//Numbers of Food Stations 
	FoodStation station1;
	FoodStation station2;
	FoodStation station3;
	private int flagLast;
	
	//Numbers of Ant
	private Ant player;
	private int speedLimit;
	
	public GameWorld() {
		gameObjects = new ArrayList<>();
	}
	
	public void init(){
		// Create 5 Flag objects and add them into the ArrayList
		flag1 = new Flags((float) 200.0, (float) 200.0, 1);
		gameObjects.add(flag1);
		flag2 = new Flags((float) 200.0, (float) 800.0, 2);
		gameObjects.add(flag2);
		flag3 = new Flags((float) 700.0, (float) 800.0, 3);
		gameObjects.add(flag3);
		flag4 = new Flags((float) 800.0, (float) 700.0, 4);
		gameObjects.add(flag4);
		flag5 = new Flags((float) 900.0, (float) 400.0, 5);
		gameObjects.add(flag5);
		
		flagLast = 5;
		
		player = new Ant((float) 502.1, (float) 394.9, 0, 7, 100);
		gameObjects.add(player);
		speedLimit = player.getMaximumSpeed();
		
		// Create 3 Spider objects and add them into the ArrayList
		spider1 = new Spider(randomGenerator.nextInt(61) + 10, (randomGenerator.nextFloat() * WIDTH), (randomGenerator.nextFloat() * HEIGHT),  randomGenerator.nextInt(360), randomGenerator.nextInt(11) + 5, 100);
		gameObjects.add(spider1);
		spider2 = new Spider(randomGenerator.nextInt(61) + 10, (randomGenerator.nextFloat() * WIDTH), (randomGenerator.nextFloat() * HEIGHT), randomGenerator.nextInt(360), randomGenerator.nextInt(11) + 5, 100);
		gameObjects.add(spider2);
		spider3 = new Spider(randomGenerator.nextInt(61) + 10, (randomGenerator.nextFloat() * WIDTH), (randomGenerator.nextFloat() * HEIGHT), randomGenerator.nextInt(360), randomGenerator.nextInt(11) + 5, 100);
		gameObjects.add(spider3);
		
		//Create 3 FoodStation objects and add them into the ArrayList 
		station1 = new FoodStation(randomGenerator.nextInt(61) + 10, (randomGenerator.nextFloat() * WIDTH), (randomGenerator.nextFloat() * HEIGHT));
		gameObjects.add(station1);
		station2 = new FoodStation(randomGenerator.nextInt(61) + 10,(randomGenerator.nextFloat() * WIDTH), (randomGenerator.nextFloat() * HEIGHT));
		gameObjects.add(station2);
		station3 = new FoodStation(randomGenerator.nextInt(61) + 10, (randomGenerator.nextFloat() * WIDTH), (randomGenerator.nextFloat() * HEIGHT));
		gameObjects.add(station3);
	}

	public void accelerate() {
		if (player.getInitialSpeed() + 2 < speedLimit) 
			player.setInitialSpeed(player.getInitialSpeed() + 2);
		else if (player.getInitialSpeed() + 2 >= speedLimit)
			player.setInitialSpeed(speedLimit);
		player.move(player.getInitialHeading(), player.getInitialSpeed());
	}

	public void brake() {
		if (player.getInitialSpeed() - 2 > 0)
			player.setInitialSpeed(player.getInitialSpeed() - 2);
		else if (player.getInitialSpeed() - 2 <= 0)
			player.setInitialSpeed(0);
		player.move(player.getInitialHeading(), player.getInitialSpeed());
		
	}
	
	public void turnLeft() {
		player.changesHead(-5);
		player.move(player.getInitialHeading(), player.getInitialSpeed());
	}
	
	public void turnRight() {
		player.changesHead(+5);
		player.move(player.getInitialHeading(), player.getInitialSpeed());
	}
	
	public void consumptionRate() {  // Set a predefined food consumption rate for the ant
	    int newRate = (int) 0.5; // You can set this rate to any desired value
	    
	    player.setFoodConsumptionRate(newRate); // Set the food consumption rate of the ant to the predefined rate
	}
	
	public void collideWithFlag(int flagSeqNum) {
		if (player.getLastFlagReached() == flagSeqNum - 1)
			player.setLastFlagReached(flagSeqNum);
		
		if (player.getLastFlagReached() == flagLast) {
			System.out.println("\nGame over!, you win! Your time: " + clock);
			System.exit(0);
		}
	}
	
	public void collideWithFoodStation() {
		ArrayList<FoodStation> availableStations = new ArrayList<FoodStation>();
		FoodStation chosenStation;
		
		for (GameObject g : gameObjects) {
			if (g instanceof FoodStation && ((FoodStation) g).getCapacityOfFood() != 0) {
				availableStations.add((FoodStation) g);
			}
		}
		
		chosenStation = availableStations.get(randomGenerator.nextInt(3));
			
		player.setHealthLevel(chosenStation.getCapacityOfFood());
		chosenStation.setCapacityOfFood(0);
		chosenStation.setColor(175, 255, 175); 
		FoodStation newStation = new FoodStation(randomGenerator.nextInt(61) + 10, (randomGenerator.nextFloat() * WIDTH), (randomGenerator.nextFloat() * HEIGHT));
		gameObjects.add(newStation);
	}
	
	public void collideWithSpider() {
		player.setHealthLevel(player.getHealthLevel() - 1);
		player.setColor(255, 255 * (player.getHealthLevel() / 10), 255 * (player.getHealthLevel() / 10));
		
		speedLimit = player.getMaximumSpeed() * (player.getHealthLevel() / 10);
		
		if (player.getInitialSpeed() > speedLimit)
			player.setInitialSpeed(speedLimit);
		
		// if the health level is 0 
		if (player.getHealthLevel() == 0) {
			lives--; // subtract one life 
			
			// if there lives = 0, game over 
			if (lives == 0) {
				gameObjects.clear();
				System.out.println("\nHealth level is 0. 1 life lost. Remaining lives: " + lives);
				System.out.println("\nGame over!, you failed!");
				System.exit(0);
			// else, just restart 
			} else if (lives > 0) {
				gameObjects.clear();
				System.out.println("\nHealth level is 0. 1 life lost. Remaining lives: " + lives);
				init();
			}
		}
	}
	
	public void tickClock() {
		for (GameObject g : gameObjects) {
			if (g instanceof MovableGameObject && g instanceof Spider) 
				((MovableGameObject) g).setInitialHeading(randomGenerator.nextInt(5 + 5) - 5);
		}
		
		// Movable objects are told to update positions according to heading and speed
		for (GameObject g : gameObjects) {
			if (g instanceof MovableGameObject) {
				((MovableGameObject) g).move(((MovableGameObject) g).getInitialHeading(), ((MovableGameObject) g).getInitialSpeed());
			}
		}
		
		// Ants food level is reduced by FoodConsumpionRate 
		player.setHealthLevel(player.getHealthLevel() - player.getFoodConsumptionRate());
		
		clock++; // Game clock is implement by 1 
	}
	
	public void outputMap() {
		for (GameObject g : gameObjects) 
			System.out.println(g.toString());
	}
	
	public void display() {
		System.out.print("\nNumber of lives left: " + lives);
		System.out.print("\nTime Elapsed : " + clock);
		System.out.print("\nHighest flag reached: " + player.getLastFlagReached());
		System.out.print("\nCurrent health: " + player.getHealthLevel());
		System.out.print("\nCurrent food level: " + player.getHealthLevel());
	}
	
	public void exit() {
		System.out.println("\nPlease Confirm that you want to exit the game? Y/N: ");
	}


}