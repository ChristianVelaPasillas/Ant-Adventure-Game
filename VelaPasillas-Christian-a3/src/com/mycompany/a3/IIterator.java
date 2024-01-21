package com.mycompany.a3;

/*
 * Interface to implement methods in GameObjectCollection class
 */
public interface IIterator {
	
	public boolean hasNext();
	
	 // Method to get the next element in the collection.
	public GameObject getNext();
	
	 // It returns the current GameObject being pointed
	public GameObject getCurrent();

	// This method allows for modifying the collection during iteration, typically removing the current element.
	void remove(GameObject object);

}