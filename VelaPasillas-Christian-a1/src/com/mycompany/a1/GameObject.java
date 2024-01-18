// Name: Christian Vela Pasillas
// Class: CSC 133-02
// Professor: Dr. Pınar Muyan-Özçelik

package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject { //Define abstract class named GameObject
	
	//The Variables are
	private int objectColor;
	private int objectSize;
	private Point objectLocation;

	// size is the size of the object, and a and b are the coordinates of the object
	public GameObject(int objectSize, float a, float b, int redComponent, int greenComponent, int blueComponent) { // redComponent, greenComponent, blueComponent are the color components
		this.objectSize = objectSize;
		this.objectLocation = new Point(a, b);
		this.objectColor = ColorUtil.rgb(redComponent, greenComponent, blueComponent);
	}

	public String printColor() {  // This is a method to print the object's color
		return "color = [" + ColorUtil.red(this.getColor()) + "," + ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "]";
	}
	
	public String printSize() { // This is a method to print the object's size
		return "size = " + this.getObjectSize();
	}
	
	public String printLocation() { // This is a method to print the object's location
		return "loc = " + Math.round(this.objectLocation.getX() * 10.0) / 10.0 + "," + Math.round(this.objectLocation.getY() * 10.0) / 10.0;
	}	

    public int getObjectSize() { // Getter for object size
        return this.objectSize;
    }

    public void setObjectSize(int objectSize) { // Setter for object size
        this.objectSize = objectSize;
    }
    
    public int getColor() {  // Getter for object color
		return this.objectColor;
	}
    
    public void setColor(int redComponent, int greenComponent, int blueComponent) {  // Setter for object color
		this.objectColor = ColorUtil.rgb(redComponent, greenComponent, blueComponent);
	}

	public static Object get(int i) {
		return null;
	}
	public Point getObjectLocation() {  // Getter for object location
		return this.objectLocation;
	}
	
	public void setLocation(float a, float b) { // Setter for object location
		this.objectLocation.setX(a);
		this.objectLocation.setY(b);
	}
}

