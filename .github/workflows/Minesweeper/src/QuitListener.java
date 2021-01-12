import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//The point of this class is to quit the program
public class QuitListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//Just quit
		System.exit(0);
		
	}

}
