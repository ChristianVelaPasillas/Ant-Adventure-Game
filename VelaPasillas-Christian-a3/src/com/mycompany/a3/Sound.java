package com.mycompany.a3;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound {  // Constructor for the Sound class.
	
	private Media m; // Media object to handle audio playback.
	public Sound(String fileName) {
		try {
			
			// Getting the audio file as an InputStream.
			InputStream in = Display.getInstance().getResourceAsStream(getClass(),"/"+fileName);
			
			// Creating a Media object from the InputStream.
			m = MediaManager.createMedia(in, "audio/wav");
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void play() { // Method to play the sound.
		
		m.setTime(0);  // Resetting the time to 0 to start the audio
		m.play(); // Playing the audio.
	}
}