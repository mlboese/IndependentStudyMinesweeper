
/*This is the tile object class*/

public class Tile {
	
	//I'll be declaring my variables here
	boolean isMine; //Determine if the tile is a mine
	boolean isOpen; //Determines if the tile is uncovered
	boolean isMarked; //Determines if there's a value in the tile
	int value; //Determines the number of mines around it
	//Any blank mine will actually get a value of 9, since it's not possible
		//to have 9 mines surrounding a tile
		//Similarly a blank tile will have a value of 0
	boolean isHighlighted;
	
	//This is the constructor
	public Tile(boolean isMine, boolean isOpen, boolean isMarked, int value, boolean isHighlighted) {
		this.isMine = isMine;
		this.isOpen = isOpen;
		this.isMarked = isMarked;
		this.value = value;
		this.isHighlighted = isHighlighted;
	}
	
	
	//--------------------------------Get Methods------------------------------------
	
	//isMine
	public boolean getIsMine() {
		return isMine;
	}
	
	//isOpen
	public boolean getIsOpen() {
		return isOpen;
	}
	
	//isBlank
	public boolean getIsMarked() {
		return isMarked;
	}
	
	//value
	public int getValue() {
		return value;
	}
	
	//isHighlighted
	public boolean getIsHighlighted() {
		return isHighlighted;
	}
	
	
	//--------------------------------Set Methods------------------------------------
	
	//isMine
	public void setIsMine(boolean x) {
		isMine = x;
	}
	
	//isOpen
	public void setIsOpen(boolean x) {
		isOpen = x;
	}
	
	//isBlank
	public void setIsMarked(boolean x) {
		isMarked = x;
	}
	
	//value
	public void setValue(int x) {
		value = x;
	}
	
	//isHighlighted
	public void setIsHighlighted(boolean x) {
		isHighlighted = x;
	}
	
	
	
	//---------------------------------To String--------------------------------------
	
	public String toString() {
		return "Is Mine: "+isMine+" | Is Open: "+isOpen+" | Is Marked: "+isMarked+" | Value: "+value
				+" | Is Highlighted "+isHighlighted;
	}
	
}
