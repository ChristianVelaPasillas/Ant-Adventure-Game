package com.mycompany.a3;
import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSound implements Runnable{

	private Media m;
	
	
	public BGSound(String fileName) { //Load the media file
		while(m == null) {
			try {
				InputStream inputStream = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
				m = MediaManager.createMedia(inputStream,"audio/wav", this);
			}
		
			catch(Exception e) {
				//Print Error message.
				e.printStackTrace();
				System.out.println("Cannot Play Sound");
			}
		}
	}
	public void pause() { //Method to pause the pause
		m.pause();
	}
	public void play() { //Method to play the sound
		m.play();
	
	} //Method called 
	public void run() {
		m.setTime(0); // Reset the time to start from beginning
		m.play(); //Plays the sound
	}

}