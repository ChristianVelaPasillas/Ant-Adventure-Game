package com.mycompany.a3;
import com.codename1.ui.Graphics; 
import com.codename1.ui.geom.Point;

//The ICollider interface, defining methods for collision handling in the game.
public interface IDrawable {
	
	//Method to draw object on component
	public void draw(Graphics g, Point pCmpRelPrnt);
}