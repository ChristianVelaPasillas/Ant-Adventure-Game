// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;


import java.util.Observable;
import java.util.Random;


/**
 * 
 *
 */
public class GameWorld extends Observable {
	
	private int elapsedTime;
	private int antLives;
	private int foodLevel;
	private int lastFlagReached;
	private boolean soundSetting;
	private int healthLevel;
	private GameObjectCollection gameObjects;
	private Ant theAnt;
	Random random = new Random();
	private int gameWorldHeight;
	private int gameWorldWidth;

	public GameWorld() {}
	
	//Method to create initial state of world
	public void init() {
		
		antLives = 3;
		 this.elapsedTime = 0;
		lastFlagReached = 1;
		setHealthLevel(10);
		setFoodLevel(15);
		gameObjects = new GameObjectCollection();

		this.soundSetting = false;
		this.setChanged();
		this.notifyObservers(this);
	
		//Creating objects of world
		createFoodStations();
		createFlags();
		createSpiders();
		theAnt = createAnt();
		
	}

	/**
	 * Method to create Ant using singleton
	 * @return theAnt
	 */
	public Ant createAnt() {
		
		gameObjects.add(Ant.getTheAnt());
		theAnt = Ant.getTheAnt();
		return theAnt;

	}
	
	//Creating Spider object
	public void createSpiders() {
		
		Spider spider1 = new Spider();
		Spider spider2 = new Spider();
		gameObjects.add(spider1);
		gameObjects.add(spider2);
	}
	
	//Create flags objects
	public void createFlags() {
		
		Flags flag1 = new Flags();
		flag1.setLocationX(200);
		flag1.setLocationY(900);
		gameObjects.add(flag1);
		
		Flags flag2 = new Flags();
		flag2.setLocationX(500);
		flag2.setLocationY(100);
		gameObjects.add(flag2);
		
		Flags flag3 = new Flags();
		flag3.setLocationX(900);
		flag3.setLocationY(400);
		gameObjects.add(flag3);
		
		Flags flag4 = new Flags();
		flag4.setLocationX(100);
		flag4.setLocationY(700);
		gameObjects.add(flag4);
	
	}
	
	//Create food stations
	public void createFoodStations() {
		
		FoodStation foodStation1 = new FoodStation();
		FoodStation foodStation2 = new FoodStation();
		
		gameObjects.add(foodStation1);
		gameObjects.add(foodStation2);
		
	}
	//Creating additional food stations
	public void addFoodStation() {
		
		FoodStation newStation = new FoodStation();
		gameObjects.add(newStation);
	}
	/**
	 * Method to get Ant current lives
	 * @return antLives
	 */
	public int getAntLives() {
		return antLives;
	}
	
	//Method call to change Ant speed
	public void changeSpeed(char c) {
		
		theAnt.changeSpeed(c);
			
	}
	//Method call to change Ant direction
	public void changeDirection(char c) {
		
		theAnt.changeDirection(c);
		
	}
	//Method to notify flag collision
	public void flagCollision(int i) {
		
		int flag = i;
		if((flag == lastFlagReached + 1)) {
			setLastFlagReached(flag);
			System.out.println("\nYou have reached flag #" + flag);
			if(lastFlagReached == 4) {
				System.out.println("\nGame over! You win!");
				System.out.println("Total time: " + getTime() + " ticks");
				System.exit(0);
			}
			
		}
		else {
			System.out.println("\nYou can't jump to this flag!");
			
		}
		
		this.setChanged();
		this.notifyObservers(this);
		
	}
	//Method to update last flag reached
	public void setLastFlagReached(int x) {
		
		lastFlagReached = x;
	}
	//Method to request current flag
	public int getLastFlagReached() {
		
		return lastFlagReached;
	}
	//Method to notify food station collision
	public void foodCollision() {
		
		System.out.println("\nYou have reached a food station!");
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof FoodStation) {
				FoodStation station = (FoodStation) itr.getCurrent();
				if(station.getCapacity() != 0) {
					int foodLevelNew = station.getCapacity();
					setFoodLevel(foodLevelNew);
					station.setCapacity(0);
					station.setColor(255, 0, 0);
					addFoodStation();
					break;
					
				}
			}
			
			
		}
		
		this.setChanged();
		this.notifyObservers(this);
	}
	
	//Method to notify food station collision
	public void foodCollision11() {
		
		System.out.println("\nSet food consumption rate: 5");

	}
	
	//Method to notify spider collision
	public void spiderCollision() {
		
		System.out.println("\nYou have collided with a Spider!");
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Spider) {
				if(getHealthLevel() != 0) {
					setHealthLevel(getHealthLevel() -1);
					if(getHealthLevel() == 0) {
						System.out.println("The Ant has lost a life...");
						int tempTime = getTime();
						int tempLives = antLives - 1;
						init();
						antLives = tempLives;
						elapsedTime = tempTime;
						this.setChanged();
						notifyObservers(this);
						
						if(antLives == 0) {
							System.out.println("Game over, you failed!");
							System.exit(0);
						}
						
					}
					System.out.println("Health: " + getHealthLevel());
					theAnt.setColor(255, 102, 102);
					break;

				}
				
			}
		}
		this.setChanged();
		this.notifyObservers(this);
		
	}
	//Method to start clock and move objects
	public void clockTick() {
		
		System.out.println("\nGame clock has ticked!");
		elapsedTime++;
		IIterator itr  = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof MovableGameObject) {
				((MovableGameObject) tempObject).moveNew();
				if(tempObject instanceof Spider) {
					Spider tempSpider = (Spider) itr.getCurrent();
					tempSpider.setDirection(random.nextInt(359));
					tempSpider.getDirection();
				}
			}
		}
		foodLevel = foodLevel - theAnt.getFoodConsumptionRate();
		if(foodLevel <= 0) {
			System.out.println("The Ant has lost a life...");
			int tempTime = getTime();
			int tempLives = antLives - 1;
			init();
			antLives = tempLives;
			elapsedTime = tempTime;
			this.setChanged();
			notifyObservers(this);
			
			if(antLives == 0) {
				System.out.println("\nGame over, you failed!");
				System.exit(0);
			}
		}
		this.setChanged();
		this.notifyObservers(this);
	}

	//Method for game map
	public void printMap() {
		
		System.out.println("\n*************** GAME MAP *******************\n");
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			System.out.println(((GameObject) itr.getNext()).toString());
		}
	
		System.out.println("\n***********************************************");

		
	}

	/*
	 * Method to get game clock
	 */
	public int getTime() {
		
		return this.elapsedTime;
	}
	/*
	 * Method to get sound setting
	 */
	public boolean getSound() {
		
		return soundSetting;
	}
	/*
	 * Method to set sound setting
	 */
	public void setSound() {
		
		if(soundSetting)
			soundSetting = false;
		else
			soundSetting = true;
		
		this.setChanged();
		this.notifyObservers(this);
		
		
	}
	/**
	 * Method to request health
	 * 
	 * @return healthLevel
	 */
	public int getHealthLevel() {
		
		return healthLevel;
	}
	/**
	 * Method to set health
	 * 
	 * @param x
	 */
	public void setHealthLevel(int x) {
		
		healthLevel = x;
	}
	/**
	 * Method to request food level
	 * 
	 * @return foodLevel
	 */
	public int getFoodLevel() {
		
		return foodLevel;
	}
	/**
	 * Method to set food level
	 * 
	 * @param x
	 */
	public void setFoodLevel(int x) {
		
		foodLevel = x;
		
	}
	/*
	 * Method to get objects in game collection
	 */
	public GameObjectCollection getCollection() {
		
		return gameObjects;
	}
	/*
	 *Method to set game height
	 */
	public void setGameWorldHeight(int mapHeight) {

		gameWorldHeight = mapHeight;
	}
	/*
	 * Method to set game width
	 */
	public void setGameWorldWidth(int mapWidth) {
		
		gameWorldWidth = mapWidth;
	}

}
