package com.mycompany.a3;
import com.codename1.ui.Graphics; 
import com.codename1.ui.geom.Point;

public interface ISelectable {
	
	//Methods created to select objects
	public void setSelected(boolean selected);
	
	// It returns true if the object is in a selected state.
	public boolean isSelected();
	
	// This method is crucial for determining if the object should respond to user interactions.
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrint);
	
	// 'g' is the Graphics object used for drawing
	public void draw(Graphics g, Point pCmpRelPrnt);
}
