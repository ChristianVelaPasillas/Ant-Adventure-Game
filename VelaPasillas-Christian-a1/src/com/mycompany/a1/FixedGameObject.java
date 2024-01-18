// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;

//  objectSize the size of the object, also a and b are the coordinates of the object
//  valueC, valueD, valueE: values related to the object
public abstract class FixedGameObject extends GameObject {   // I Define an abstract class named FixedGameObject that extends GameObject

    public FixedGameObject(int objectSize, float a, float b, int valueC, int valueD, int valueE) {
		super(objectSize, a, b, valueC, valueD, valueE);  // I called the constructor of the superclass GameObject
    }
    @Override
	public void setLocation(float a, float b) {}

 
}

