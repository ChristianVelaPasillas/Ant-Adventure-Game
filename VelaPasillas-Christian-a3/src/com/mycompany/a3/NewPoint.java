package com.mycompany.a3;

//Importing Java's Random class for generating random numbers.
import java.util.Random;

import com.codename1.ui.geom.Point;

//NewPoint class extends Point to add additional functionality
public class NewPoint extends Point{
	
	static Random rand = new Random(); // A static Random object for generating random numbers.
	
	public NewPoint(int x, int y) {
		super(x, y);
	}
	//Method to create valid random location
	public static Point validRandomLocation(Point max, int size) {
        int tempX = 0;
        int tempY = 0;
        double maxX = max.getX();
        double maxY = max.getY();
        boolean outOfRange = true;

        // Loop to generate a random location within the specified bounds.
        while (outOfRange) {
            tempX = (rand.nextInt((int) maxX));
            tempY = (rand.nextInt((int) maxY));
            if (tempX + (size / 2) > maxX || tempX - (size / 2) < 50
                    || tempY + (size / 2) > maxY || tempY - (size / 2) < 50) {
                outOfRange = true; // If out of bounds, keep outOfRange as true 
            } else {
                outOfRange = false; // If within bounds, set outOfRange to false to exit
            }
        }
            return new Point(tempX, tempY); // Return the new Point that is within the specified bounds.
    }


}