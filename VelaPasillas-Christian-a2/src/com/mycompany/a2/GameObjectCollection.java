// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;


import java.util.ArrayList;

public class GameObjectCollection implements ICollection {
	
	private ArrayList<GameObject> gameObjects;
	
	/*
	 * Constructor that creates new game objects
	 */
	public GameObjectCollection() {
		gameObjects = new ArrayList<GameObject>();
	}
	
	/*
	 * Method to add objects into array list
	 */
	@Override
	public void add(GameObject obj) {
		
		gameObjects.add(obj);
		
	}
	
	/*
	 * Method to get Iterator
	 */
	@Override
	public IIterator getIterator() {
		
		return new GameObjectIterator();
	}
	/*
	 * Private class to create iterator
	 */
	 private class GameObjectIterator implements IIterator {
		 
		 private int index;
		 
		 /*
		  * Iterator constructor
		  */
		 public GameObjectIterator() {
			 
			 index = -1;
		 }
		 @Override
		 public boolean hasNext() {
			
			 if(gameObjects.size() <= 0)
				 return false;
			 
			 if(index == gameObjects.size() -1) {
				 return false;
			 }
			 
			 return true;
		 }
		@Override
		public GameObject getNext() {
			
			index++;
			return gameObjects.get(index);
		}
		@Override
		public GameObject getCurrent() {
			
			return gameObjects.get(index);
		}
		
	 }


}
