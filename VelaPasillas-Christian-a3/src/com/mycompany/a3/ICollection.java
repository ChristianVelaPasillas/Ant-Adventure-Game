package com.mycompany.a3;

public interface ICollection {
	
	/*
	 * Method to add objects of type GameObject
	 * It allows for adding a GameObject to the collection.
	 */
	public void add(GameObject obj);
	
	// This method will be implemented to return an IIterator instance.
    // It enables iterating over the collection of GameObjects.
	IIterator getIterator();
	

}