import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class is to change the mouse settings
public class SelectionListener implements ActionListener{
	
	//I need a code for what the mouse should be set to
	//and the mouse to update
	int code;
	Mouse mouse;
	
	public SelectionListener(int c, Mouse m) {
		code = c;
		mouse = m;
	}
	
	//----------------------------Get and Set Methods----------------------------
	//Code
	public int getCode() {
		return code;
	}
	public void setCode(int newCode) {
		code = newCode;
	}
	
	//Mouse
	public Mouse getMouse() {
		return mouse;
	}
	public void setMouse(Mouse newMouse) {
		mouse = newMouse;
	}
	
	//ToString
	public String toString() {
		return "Code: "+code+" | Mouse: "+mouse.toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//First remove all current attributes of the mouse
		mouse.setIsMark(false);
		mouse.setIsUncover(false);
		mouse.setIsSelect(false);
		
		//Set the mouse depending on the code
		//Code 1 is the uncover
		if (code == 1) {
			mouse.setIsUncover(true);
		}
		//Code 2 is the mark
		else if (code == 2) {
			mouse.setIsMark(true);
		}
		//Code 3 is the selection
		else if (code == 3) {
			mouse.setIsSelect(true);
		}
		//Else print out something went wrong
		else {
			System.out.println("The code for updating mouse was invalid.");
		}
		
	}

}
