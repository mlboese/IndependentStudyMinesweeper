

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

//This class is to keep track of all the Action Events
//It just keeps the MakeWindow method cleaner

public class FieldListens implements MouseListener{
	
	//Create an object to obtain variables
	Tile[][] map;
	Window window;
	JPanel[][] panelArr;
	Counters counter;
	JLabel left;
	Mouse mouse;
	
	
	public FieldListens(Tile[][] m, Window w, JPanel[][] l, Counters c, JLabel lf, Mouse ms) {
		map = m;
		window = w;
		panelArr = l;
		counter = c;
		left = lf;
		mouse = ms;
	}
	
	//----------------Get and Set Methods----------------------------
	
	//Map
	public Tile[][] getMap(){
		return map;
	}
	public void setMap(Tile[][] newMap) {
		map = newMap;
	}
	
	//Window
	public Window getWindow() {
		return window;
	}
	public void setWindow(Window newWindow) {
		window = newWindow;
	}
	
	//Label array
	public JPanel[][] getPanelArr(){
		return panelArr;
	}
	public void setPanelArr(JPanel[][] newPanelArr) {
		panelArr = newPanelArr;
	}
	
	//Counter
	public Counters getCounter() {
		return counter;
	}
	public void setCounter(Counters newCounter) {
		counter = newCounter;
	}
	
	//Mines left
	public JLabel getLeft() {
		return left;
	}
	public void setLeft(JLabel newLeft) {
		left = newLeft;
	}
	
	//Mouse
	public Mouse getMouse() {
		return mouse;
	}
	public void setMouse(Mouse newMouse) {
		mouse = newMouse;
	}
	
	//To String
	public String toString() {
		return "Panel Array: "+panelArr.toString()+" | Map: "+map.toString()
			+" | Window: "+window.toString()+" | Counter: "+counter.toString()+" | JLabel left: "
			+left.toString()+" | Mouse: "+mouse.toString();
	}
	
	
	//-----------------To visually uncover a tile--------------------------------
	public void revealTile(JPanel panel, int value, Tile tile) {
//		
		//Set the button to a panel with the correct number
		try {
			
			//And create an empty icon image and label
			ImageIcon icon;
			JButton replacement = new JButton();
			//Add the action listener
			FieldListens fListens = new FieldListens(map, window, panelArr, counter, left, mouse);
			replacement.addMouseListener(fListens);
			int size = (int)((window.getWidth()/map[0].length)-((window.getWidth()/map[0].length)*.1));
			
			String url = "";
			if (tile.getIsHighlighted()) {
				url += "Selected";
			}
			
			//This can be on a scale from 0-9 depending on what goes there
			//So I need 10 if statements
			if (value == 0) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/blankTile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 1) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/1Tile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 2) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/2Tile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 3) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/3Tile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 4) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/4Tile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 5) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/5Tile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 6) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/6Tile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 7) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/7Tile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 8) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/8Tile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else if (value == 9) {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/mineTile"+url+".png"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered");
			}
			
			
			else {
				//Set the icon
				icon = window.createIcon(getClass().getResource("Assets/test.jpg"), size);
				replacement.setIcon(icon);
				panel.remove(0);
				panel.revalidate();
				panel.repaint();
				panel.add(replacement);
				System.out.println("Tile uncovered but something went wrong");
			}

			
			
			
			
			
		//A lot of different tile types
		//-----------------------------------------------------------------
			
		}
		
		catch(Exception ex) {
			System.out.println("Error while processing uncover: "+ex);
		}
		
		
		
	}
	
	
	//---------------------------------------------------------------------------------
	
	//------------------------------Selection method----------------------------------
	
	//This method highlights all relevant tiles when called
	public void highlightTiles(int indexX, int indexY) {

		
		//Find the size of the tile
		int size = (int)((window.getWidth()/map[0].length)-((window.getWidth()/map[0].length)*.1));
		
		//Remove any previous highlights
		for (int i = 0; i<map.length; i++) {
			for (int j = 0; j<map[i].length; j++) {
				//If the button is highlighted
				if (map[i][j].getIsHighlighted()) {
					//Set the tile to not highlighted
					map[i][j].setIsHighlighted(false);
					int value = map[i][j].getValue();
				
					
					//Remove the highlight
					if (map[i][j].getIsMarked()) {
						//Get the current button
						JButton thisButton = (JButton)panelArr[i][j].getComponentAt(0, 0);
						//Create an icon for the flag
						Icon flagIcon = window.createIcon(getClass().getResource("Assets/markedFlag.png"), size);
						thisButton.setIcon(flagIcon);
					}
					else if (!map[i][j].getIsOpen()) {
						//Get the current button
						JButton thisButton = (JButton)panelArr[i][j].getComponentAt(0, 0);
						//Create an icon for a hiddentile
						Icon hiddenIcon = window.createIcon(getClass().getResource("Assets/hiddenTile.png"), size);
						thisButton.setIcon(hiddenIcon);
					}
					else {
						//Otherwise use the method reveal tile
						revealTile(panelArr[i][j], value, map[i][j]);
					}
				}
			}
		}
		
		//Then add all the highlights
		//Go in a square from -1, -1 to 1, 1, relative to the tile
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				//Make sure not to go off the edge of the board
				if ((indexY + i) >= 0 && (indexY + i) < panelArr.length
						&& (indexX + j) >= 0 && (indexX + j) < panelArr[indexY].length) {
					map[indexY+i][indexX+j].setIsHighlighted(true);
					//Set the highlight
					if (map[indexY+i][indexX+j].getIsMarked()) {
						//Get the current button
						JButton thisButton = (JButton)panelArr[indexY+i][indexX+j].getComponentAt(0, 0);
						//Create an icon for the flag
						Icon flagIcon = window.createIcon(getClass().getResource("Assets/markedFlagSelected.png"), size);
						thisButton.setIcon(flagIcon);
						System.out.println("Index "+(indexY+i)+", "+(indexX+j)+" was marked"
								+ "because the tile was marked.");
					}
					else if (!map[indexY+i][indexX+j].getIsOpen()) {
						//Get the current button
						JButton thisButton = (JButton)panelArr[indexY+i][indexX+j].getComponentAt(0, 0);
						//Create an icon for a hidden tile
						Icon hiddenIcon = window.createIcon(getClass().getResource("Assets/hiddenTileSelected.png"), size);
						thisButton.setIcon(hiddenIcon);
						System.out.println("Index "+(indexY+i)+", "+(indexX+j)+" was marked"
								+ "because the tile was not open");
					}
					else {
						//Otherwise use the method reveal tile
						revealTile(panelArr[indexY+i][indexX+j], map[indexY+i][indexX+j].getValue(), map[indexY+i][indexX+j]);
						System.out.println("Index "+(indexY+i)+", "+(indexX+j)+" was marked"
								+ "because the tile was not marked and was open");
					}
				}
			}
		}
	}
	
	
	//----------------------------------Recursive function--------------------
	public void recursiveMethod(int indexX, int indexY) {
		//This method will uncover all the tiles and the tiles around it if they are blank
		//using recursion
		//Set up variables
		Tile tile = map[indexY][indexX];
		JPanel panel = panelArr[indexY][indexX];
		
		//Nothing matters if the tile is already marked
		if (!map[indexY][indexX].getIsMarked()) {
	
			//Now get the value of the tile
			int value = tile.getValue();
			//Uncover the tile with the corresponding value
			revealTile(panel, value, tile);
			System.out.println(" at "+indexY+", "+indexX);
			//Mark the current space as explored
			map[indexY][indexX].setIsOpen(true);
			
			//Here we'll use the recursion to reveal all corresponding tiles
			if (value == 0) {
				
				//Call the recursive function on all adjacent spaces that have
				//not been explored
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						//Make sure not to go off the edge of the board
						if ((indexY + i) >= 0 && (indexY + i) < panelArr.length
								&& (indexX + j) >= 0 && (indexX + j) < panelArr[indexY].length) {
							//Make sure the tile is open
							if (!map[indexY+i][indexX+j].getIsOpen()) {
								recursiveMethod((indexX+j), (indexY+i));
							}
						}
					}
				}
			}
		}
	}
	
	
	//------------------------------------------------------------------------
	
	//------------------------------Actual action listener-----------------------------
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//This is the actual action listener method
		//It sets things up for the recursive method then plays it through
		
		//First we need information
		System.out.println("\nButton pressed");
		//Get the current position
		//Get the JPanel
		Object button = e.getSource();
		//Make a placeholder index variable
		int indexX = 0;
		int indexY = 0;
		

		//Use a for loop to find the location of the button
		for (int i = 0; i<panelArr.length; i++) {
			for (int j = 0; j<panelArr[i].length; j++) {
				if (panelArr[i][j].getComponent(0) == button) {
					indexX = j;
					indexY = i;
					System.out.println("The value is: "+indexX+", "+indexY);
				}
			}
		}
		
		
		//----------------------------If the left button is clicked--------------------------
		
		if (e.getButton() == MouseEvent.BUTTON1 && !mouse.getIsMark()) {
			
			//Check if the mouse is selected to select mode
			if (mouse.getIsSelect()) {
				highlightTiles(indexX, indexY);
			}
			//Otherwise go through the other options
			else {
				
				//Check to make sure the tile is not flagged
				if (!map[indexY][indexX].getIsMarked()) {
				
					//If the mouse is selected to uncover mode
					if (mouse.getIsUncover()) {
						//If the tile values are 10, a new map needs to be made
						if (map[0][0].getValue() == 10) {
							//Create the algorithms class
							Algorithms algo = new Algorithms();
							map = algo.positionMines(map, counter.getTotal(), indexX, indexY);
							map = algo.placeNum(map);
						}
						
						//If the tile was a mine, end the game
						if (map[indexY][indexX].getIsMine()) {
							window.makeGameOverWindow(2, counter.total, map, window);
							window.setEnabled(false);
						}
						
						//Call the recursive method
						recursiveMethod(indexX, indexY);
					}
				}
			}
			
			//This is actually really important
			window.setVisible(true);	
			} 
		
		//----------------------------------------------------------------------------
		
		//--------------------------If the right button is clicked--------------------
		
		else if (e.getButton() == MouseEvent.BUTTON3 || mouse.getIsMark()) {
			//We'll replace the image with a marked mine image
			
			FieldListens listens = new FieldListens(map, window, panelArr, counter, left, mouse);
			try {
				//Make a panel variable
				JPanel panel = panelArr[indexY][indexX];
				ImageIcon icon;
				//Make a variable for the size of the icon
				int size = (int)((window.getWidth()/map[0].length)-((window.getWidth()/map[0].length)*.1));
				
				//If the mine is already marked unmark it
				if (map[indexY][indexX].getIsMarked()) {
					JButton hiddenTile = new JButton();
					icon = window.createIcon(getClass().getResource("Assets/hiddenTile.png"), size);
					hiddenTile.setIcon(icon);
					//Add a mouse listener to the button
					hiddenTile.addMouseListener(listens);
					panel.remove(0);
					panel.revalidate();
					panel.repaint();
					//Add the button
					panel.add(hiddenTile);
					//Undo the mark
					map[indexY][indexX].setIsMarked(false);
					//Remove all appropriate counters
					counter.setMarked(counter.marked-1);
					if (map[indexY][indexX].getIsMine()) {
						counter.setCovered(counter.covered-1);
					}
					//Also change the counter at the top
					left.setText(" "+(counter.total-counter.marked)+" ");
				}
				
				//Otherwise mark it
				else {
					//Create a button
					JButton replacement = new JButton();
					
						//Set the icon
						icon = window.createIcon(getClass().getResource("Assets/markedFlag.png"), size);
						replacement.setIcon(icon);
						replacement.addMouseListener(listens);
						panel.remove(0);
						panel.revalidate();
						panel.repaint();
						panel.add(replacement);
						System.out.println("Tile marked");
						//Mark the tile as marked
						map[indexY][indexX].setIsMarked(true);
						//Add all appropriate counters
						counter.setMarked(counter.marked+1);
						if (map[indexY][indexX].getIsMine()) {
							counter.setCovered(counter.covered+1);
						}
						//Also change the counter at the top
						left.setText(" "+(counter.total-counter.marked)+" ");
					}
				}
				//Just in case because icon images seem to be easy to fail
				catch(Exception ex) {
					System.out.println("Error marking tile: "+ex);
			}
		}
		
		//After everything is settled check to see if the game has been won
		
		//Check if all the tiles are marked or uncovered
		boolean isAllOpen = true;
		for (int i = 0; i<map.length; i++) {
			for (int j = 0; j<map[i].length; j++) {
				if (!map[i][j].getIsMarked() && !map[i][j].getIsOpen()) {
					System.out.println("There are unopened tiles");
					isAllOpen = false;
				}
			}
		}
		//Check if all the mines are correctly marked
		boolean isCovered = false;
		if (counter.getTotal() == counter.getCovered()) {
			isCovered = true;
			System.out.println("The count has been met");
		}
		else {
			System.out.println("The count has not been met.");
			System.out.println("Total Mines: "+counter.getTotal()+
					" | Covered: "+counter.getCovered());
		}
		
		//Combine them to see if the game has been won
		if (isAllOpen && isCovered) {
			//If it has open the game won menu
			System.out.println("The game has been won");
			window.makeGameOverWindow(3, counter.total, map, window);
			window.setEnabled(false);
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	

}
