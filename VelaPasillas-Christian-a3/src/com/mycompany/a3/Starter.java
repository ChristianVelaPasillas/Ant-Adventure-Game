package com.mycompany.a3;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class Starter {

    private Form current; // Current form displayed in the application.
    private Resources theme; // Theme resources for the application

    public void init(Object context) {  // Initialize the application state.
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        setTheme(UIManager.initFirstTheme("/theme"));

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        new Game(); // Starting a new game instance.
    }

    public void stop() { // This method is called when the application is stopped.
        current = getCurrentForm(); // Getting the current form.
        if(current instanceof Dialog) {
            ((Dialog)current).dispose(); // Disposing the dialog if the current form is a dialog.
            current = getCurrentForm(); // Updating the current form reference.
        }
    }
    
    public void destroy() { // Called when the application is destroyed.
    }

	public Resources getTheme() { //getTheme
		return theme;
	}

	public void setTheme(Resources theme) { //setTheme
		this.theme = theme;
	}

}