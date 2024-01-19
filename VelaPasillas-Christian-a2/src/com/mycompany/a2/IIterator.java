// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;

/*
 * Interface to implement methods in GameObjectCollection class
 */
public interface IIterator {
	
	public boolean hasNext(); // True if there is a next element, false otherwise
	
	public GameObject getNext(); // The next game object
	
	public GameObject getCurrent(); // The current game object

}
