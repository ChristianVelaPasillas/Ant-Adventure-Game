// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;


public class FoodStation extends FixedGameObject {  // I Define a class named FoodStation that extends FixedGameObject
    private int capacityOfFood;

    public FoodStation(int size, float a, float b) { // size is the size of the food station
    	super(size, a, b, 0, 255, 0); // a and b are the coordinates of the food station
		this.capacityOfFood = 2 * this.getObjectSize();  // Initialize the food capacity based on the size
    }

    public int getCapacityOfFood() { // Getter for retrieving
        return this.capacityOfFood;
    }

    public void setCapacityOfFood(int capacityOfFood) { // Setter for updating
        this.capacityOfFood = capacityOfFood;
    }
    public String toString() {
		return "FoodStation: " + this.printLocation() + " " + this.printColor() + " " + this.printSize() + " foodCapacity = " + this.capacityOfFood;
	}

}
