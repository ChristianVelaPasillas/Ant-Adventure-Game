// Name: Christian Vela Pasillas.
// Class: CSC 133.
// Assignment: #4.

package com.mycompany.a4;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound {
	private Media m;
	
	/**
	 * Plays non-repeat sounds
	 * 
	 * @param fileName
	 */
	public Sound(String fileName) {
		if(Display.getInstance().getCurrent() == null) {
			System.out.println("Error: Create sound objects after calling show()!");
			System.exit(0);
			
		} try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
			
			m = MediaManager.createMedia(is, "audio/wav");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void play() {
		//start playing the sound from time zero (beginning of the sound file)
		m.setTime(0);
		m.play();
	}
	
	public void pause()
	{
		m.setTime(0);
		m.pause();
	}
}
