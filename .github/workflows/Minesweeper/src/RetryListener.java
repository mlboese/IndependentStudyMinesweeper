import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//The purpose of this class is to react to the retry button
public class RetryListener implements ActionListener{
	
	//I need the tile array and mine count to do this properly
	Tile[][] tileArr;
	int mines;
	Window oldWindow;
	
	public RetryListener(Tile[][] t, int m, Window o) {
		tileArr = t;
		mines = m;
		oldWindow = o;
	}
	
	//------------------------Get and set methods---------------------------------
	//Tile array
	public Tile[][] getTileArr(){
		return tileArr;
	}
	public void setTileArr(Tile[][] newTileArr) {
		tileArr = newTileArr;
	}
	
	//Mine count
	public int getMines() {
		return mines;
	}
	public void setMines(int newMines) {
		mines = newMines;
	}
	
	//Old window
	public Window getOldWindow() {
		return oldWindow;
	}
	public void setOldWindow(Window newOldWindow) {
		oldWindow = newOldWindow;
	}
	
	//To String
	public String toString() {
		return ("Tile Array: "+tileArr.toString()+" | Mines: "
					+mines+" | Window: "+oldWindow.toString());
	}
	
	
	//----------------------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//We'll make a new window, but it will be the same window since it
		//has the same data
		Window window = new Window();
		
		//The tiles in the tile array have to be reset other than their value
		for (int i = 0; i<tileArr.length; i++) {
			for (int j = 0; j<tileArr[i].length; j++) {
				tileArr[i][j].setIsMarked(false);
				tileArr[i][j].setIsOpen(false);
			}
		}
		
		//Make the window
		window.makeWindow(tileArr.length, tileArr[0].length, mines, tileArr);
		
		
		//Get rid of the old window
		oldWindow.setVisible(false);
		oldWindow.dispose();
		
		//Get rid of the current window
		JFrame currentFrame = (JFrame)SwingUtilities.getRoot((Component)e.getSource());
		//The above code line is credited to
		//http://www.java2s.com/Code/Java/Swing-JFC/GettheJFrameofacomponent.htm
		//Dispose of the current window
		currentFrame.setVisible(false);
		currentFrame.dispose();
	
	}
}