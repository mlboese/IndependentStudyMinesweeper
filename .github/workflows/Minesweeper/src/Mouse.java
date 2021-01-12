//This class is for keeping track of the mouse and the mode the pointer is in
//It will be an object class
public class Mouse {
	
	//Initialize the variables
	boolean isUncover; //Is the mouse uncovering tiles?
	boolean isMark; //Is the mouse marking mines?
	boolean isSelect; //Is the mouse selecting relevant tiles?
	
	//Create the object creation
	public Mouse(boolean u, boolean m, boolean s) {
		isUncover = u;
		isMark = m;
		isSelect = s;
	}
	
	//----------------Get and Set Methods--------------------------
	//Uncover
	public boolean getIsUncover() {
		return isUncover;
	}
	public void setIsUncover(boolean newIsUncover) {
		isUncover = newIsUncover;
	}
	
	//Mark
	public boolean getIsMark() {
		return isMark;
	}
	public void setIsMark(boolean newIsMark) {
		isMark = newIsMark;
	}
	
	//Select
	public boolean getIsSelect() {
		return isSelect;
	}
	public void setIsSelect(boolean newIsSelect) {
		isSelect = newIsSelect;
	}
	
	//To String
	public String toString() {
		return "Uncover: "+isUncover+" | Mark: "+isMark+" | Select: "+isSelect;
	}
	
}
