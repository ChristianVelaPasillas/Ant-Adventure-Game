package com.mycompany.a3;

public interface ICollider {
	
	//Methods to handle in game collisions
	public boolean collidesWith(GameObject otherObject);
		
	// This method will contain the logic of what happens when a collision occurs.
	public void handleCollision(GameObject otherObject);

	}