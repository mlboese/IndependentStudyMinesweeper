import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

//This class clears the highlights
public class ClearListener implements ActionListener{

	//I need the panel array and the tile array and the window
	Tile[][] map;
	JPanel[][] panelArr;
	Window window;
	
	public ClearListener(Tile[][] t, JPanel[][] p, Window w) {
		map = t;
		panelArr = p;
		window = w;
	}
	
	//-----------------------Get and Set Methods-------------------------------------
	//Map
	public Tile[][] getMap(){
		return map;
	}
	public void setMap(Tile[][] newMap) {
		map = newMap;
	}
	
	//Panel Array
	public JPanel[][] getPanelArr(){
		return panelArr;
	}
	public void setPanelArr(JPanel[][] newPanelArr) {
		panelArr = newPanelArr;
	}
	
	//Window
	public Window getWindow() {
		return window;
	}
	public void setWindow(Window newWindow) {
		window = newWindow;
	}
	
	//toString
	public String toString() {
		return "Map: "+map.toString()+" | Panel Arr: "+panelArr.toString()+
				"| Window: "+window.toString();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Clear the highlights using the same steps from fieldListens
		//The only additional thing I need is the fieldListens class
		FieldListens fListens = new FieldListens(map, window, panelArr, null, null, null);
		
		
		//Find the size of the tile
		int size = (window.getWidth()/map[0].length)-10;
		
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
						fListens.revealTile(panelArr[i][j], value, map[i][j]);
					}
				}
			}
		}
	}
}
