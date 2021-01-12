import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//This class is for when the new game button is clicked

public class NewGameListener implements ActionListener{
	
	//Make an object to get the necessary information
	
	JFormattedTextField rows;
	JFormattedTextField columns;
	JFormattedTextField mines;
	Window oldWindow;
	
	public NewGameListener(JFormattedTextField r, JFormattedTextField c, JFormattedTextField m, Window o) {
		rows = r;
		columns = c;
		mines = m;
		oldWindow = o;
	}

	//----------------------------Get and Set Methods---------------------------
	//Rows
	public JFormattedTextField getRows() {
		return rows;
	}
	public void setRows(JFormattedTextField newRows) {
		rows = newRows;
	}
	
	//Columns
	public JFormattedTextField getColumns() {
		return columns;
	}
	public void setColumns(JFormattedTextField newColumns) {
		columns = newColumns;
	}
	
	//Mines
	public JFormattedTextField getMines() {
		return mines;
	}
	public void setMines(JFormattedTextField newMines) {
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
		return ("Rows: "+rows.getText()+" | Columns: "+columns.getText()+" | Mines: "+mines.getText());
	}
	//-------------------------------------------------------------------------------
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Make a window object
		Window window = new Window();
		Algorithms algo = new Algorithms();
		
		//A whole bunch of conditions to make sure everything will run smooth
		//Each one's function is covered in the make error window function in Window
		//First grab the values if that doesn't work, the catch statement will trigger
		try {
			int rowCount = Integer.parseInt(rows.getText());
			int columnCount = Integer.parseInt(columns.getText());
			int mineCount = Integer.parseInt(mines.getText());
			
			//Make variables to track the validity of numbers (between 1 and 255)
			boolean rowValid = false;
			boolean columnValid = false;
			boolean mineValid = false;
			if (rowCount > 3 && rowCount <= 20) {
				rowValid = true;
			}
			if (columnCount > 3 && columnCount <= 20) {
				columnValid = true;
			}
			if (mineCount > 0 && mineCount <= 399) {
				mineValid = true;
			}
			
			//Check if the mine count is greater than the tile count
			if (mineCount >= (rowCount*columnCount)) {
				window.makeErrorWindow(2);
			}
			//If the counts are too big or small
			else if (!(rowValid && columnValid && mineValid)) {
				window.makeErrorWindow(3);
			}
			//If everything worked then carry on
			else {
				
				System.out.println("\n\n"+toString()+"\n\n");
				//Make a new window with the new parameters
				//Get a new tile array
				Tile[][] tileArr = algo.createMap(rowCount, columnCount);
				//And make the window
				window.makeWindow(rowCount, columnCount, mineCount, tileArr);
				
				//Get rid of the current window
				JFrame currentFrame = (JFrame)SwingUtilities.getRoot((Component)e.getSource());
				//The above code line is credited to
				//http://www.java2s.com/Code/Java/Swing-JFC/GettheJFrameofacomponent.htm
				currentFrame.setVisible(false);
				currentFrame.dispose();
				
				//And the window beforehand
				oldWindow.setVisible(false);
				oldWindow.dispose();
			}
			
		}
		//If there's no number in the text box
		catch (NumberFormatException noNum) {
			System.out.println(noNum);
			window.makeErrorWindow(1);
		}
		//Anything else
		catch (Exception ex) {
			System.out.println(ex);
			window.makeErrorWindow(4);
		}
		
	}

}
