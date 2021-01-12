import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//This class is for the new game button on the map

public class NewGameButtonListener implements ActionListener {
	//Create variables to get the old window
	Window oldWindow;
	
	public NewGameButtonListener(Window o) {
		oldWindow = o;
	}
	
	//Get and set method
	//Old window
	public Window getOldWindow() {
		return oldWindow;
	}
	public void setOldWindow(Window newOldWindow) {
		oldWindow = newOldWindow;
	}
	
	//To String
	public String toString() {
		return "Window: "+oldWindow.toString();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//The only thing this button needs to do is open the new game window...
		Window window = new Window();
		window.makeNewGameWindow();
		
		//...and close the current window
		JFrame currentFrame = (JFrame)SwingUtilities.getRoot((Component)e.getSource());
		//The above code line is credited to
		//http://www.java2s.com/Code/Java/Swing-JFC/GettheJFrameofacomponent.htm
		currentFrame.setVisible(false);
		currentFrame.dispose();
		
		//And the old window
		//Check if the value is null
		if (oldWindow != null) {
			oldWindow.setVisible(false);
			oldWindow.dispose();
		}
	}
	
}
