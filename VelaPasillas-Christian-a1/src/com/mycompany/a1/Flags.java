// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;

public class Flags extends FixedGameObject { // I Define a class named Flags that extends FixedGameObject
	private int flagsNumber;  // This is a variable to store the sequence number of the flags
    
	public Flags(float a, float b, int flagsNumber) {
		super(10, a, b, 0, 0, 255);
		this.flagsNumber = flagsNumber;  // sequence number
	}

    public int getFlagsNumber() {  // retrieving sequence number of the flags
        return this.flagsNumber;
    }
    public void setFlagsNumber(int sequenceNumber) { //updating sequence number of the flag s
		this.flagsNumber = sequenceNumber;
	} 
    @Override
	public void setColor(int redComponent, int greenComponent, int blueComponent) { }  // Flags colors
	
	public String toString() { // Custom string representation
		return "Flag: " + this.printLocation() + " " + this.printColor() + " " + this.printSize() + " sequence Number = " + this.flagsNumber;
	}
}
