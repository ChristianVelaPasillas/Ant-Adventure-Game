// Name: Christian Vela Pasillas
// Class: CSC-133 OBJ-ORIENTED CMPTR GRAPH
// Section 02
// Assignment #2

package com.mycompany.a2;


import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{ // Define a MapView class that extends Container and implements Observer
	
	private static int height;
	private static int width;
	private GameWorld gw; // Reference to the GameWorld
	
	public MapView() { // Constructor for the MapView
		
		this.getAllStyles().setBorder(Border.createLineBorder(10,ColorUtil.rgb(255, 0, 0))); // Set border style

		this.setLayout(new BorderLayout()); // Set layout to BorderLayout
		
		MapView.height = this.getHeight(); // Initialize map height
		MapView.width = this.getWidth(); // Initialize map width
	
	}
	/**
	 * Method to set map height
	 * @param h
	 */
	public static void setMapHeight(int h) {
		
		MapView.height = h;
	}
	/**
	 * Method to get map height
	 * @return height
	 */
	public static int getMapHeight() {
		
		return height;
	}
	/**
	 * Method to set mad width
	 * @param w
	 */
	public static void setMapWidth(int w) {
		MapView.width = w;
	}
	/**
	 * Method to get map width
	 * @return width
	 */
	public static int getMapWidth() {
		
		return width;
	}
	
	/**
	 * Method to update observable and data
	 */
	@Override
	public void update(Observable observable, Object data) {
		
		gw = (GameWorld) data; // Update the GameWorld reference with the new data
		IIterator itr = gw.getCollection().getIterator();
		String value = "";
		
		while(itr.hasNext()) {
			
			value = value + itr.getNext().toString() + "\n"; // Retrieve and concatenate object information
		}
		
		System.out.println("\n" + value); // Print the object information to the console
		this.repaint();  // Trigger a repaint of the MapView
		
	}

}
