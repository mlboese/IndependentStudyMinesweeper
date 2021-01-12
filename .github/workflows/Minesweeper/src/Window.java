

//Imports
import java.awt.*;
import java.net.URL;
import javax.swing.*;

/* This class handles all things dealing with the window and graphics
 * This includes action listeners for on screen clicks*/

public class Window extends JFrame{
	/**
	 * 
	 */
	//Eclipse did this automatically
	private static final long serialVersionUID = 1L;
	

	//Import other classes
	FieldListens fListen = new FieldListens(null, null, null, null, null, null);
	

	//Make a button array for later
	//It'll be used for holding the buttons
	JPanel[][] panelArr;
	
	//---------------------------Create Icons------------------------
	

	//I'm making this method to save some time when I need to convert
	//pngs into icon
	public ImageIcon createIcon(URL direct, int size) {
		try {
			
			ImageIcon unsizedImage = new ImageIcon(direct);
			//I need to do scaling based on the size of the screen
			//I create an unsized image
			Image image = unsizedImage.getImage();
			//Then create a new, sized image
			Image newimg = image.getScaledInstance(size, size, Image.SCALE_REPLICATE);
			ImageIcon icon = new ImageIcon(newimg);
			//Then return the new image icon
			return icon;
		}
		catch(Exception e) {
			System.out.println("Error processing asset: "+e);
			return null;
		}
	}
	
	//Thanks to user Tomas Narros for clarification on icons
	//https://stackoverflow.com/questions/3775373/java-how-to-add-image-to-jlabel
	//As well as the linked website
	//https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
	//-----------------------------------------------------------------

	
	
	//--------------------------Make window-----------------------------
	//Here is where I'll make the window and set up a grid with the correct
	//number of spaces and everything for the first time
	public void makeWindow(int rows, int columns, int mines, Tile[][] tilearr){
		
		//Initiate the panelArray now that we know the size of the board
		panelArr = new JPanel[rows][columns];
		System.out.println(panelArr.toString());
		
		//Create the counter for the listener
		Counters counter = new Counters(0, 0, mines);
		fListen.setCounter(counter);
		
		//Create the window
		Window frame = new Window();
		//Let the X end the program
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Name it Minesweeper
		frame.setTitle("Minesweeper");
		
		//Make a mouse object
		Mouse mouse = new Mouse(false, false, false);
		
		//To set the size, get the dimensions of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//Code accredited to:
		//http://alvinalexander.com/blog/post/jfc-swing/how-determine-get-screen-size-java-swing-app/
		
		//Get the smaller dimension so the window fits in the screen
		int smallRes;
		if (screenSize.getHeight()>screenSize.getWidth()) {
			smallRes = (int)screenSize.getWidth();
		}
		else {
			smallRes = (int)screenSize.getHeight();
		}
		System.out.println("Small Res: "+smallRes);
		//Lower small res to mostly fit the screen
		smallRes *= .75;
		double dRows = rows;
		double dColumns = columns;
		double frameWidth = (smallRes-100)/(dRows/dColumns);
		
		//Set the frame size
		frame.setSize((int)frameWidth, (smallRes));
		System.out.println("The frame width is "+frame.getWidth());
		System.out.println("The frame height is "+frame.getHeight());
		
		//Set the layout to a gridLayout
		frame.setLayout(new GridLayout(0, 1));
		
		//Make a panel for the grid bag layout
		//And set it up
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		//Make a panel for the menu and for the mine field
		JPanel menu = new JPanel();
		JPanel mineField = new JPanel();
		
		//--------------------------Menu-------------------------------------
		
		menu.setLayout(new BoxLayout(menu, BoxLayout.X_AXIS));
		menu.setMinimumSize(new Dimension((smallRes-100), 100));
		
		//The button for the mine selection
		JButton mineSelect = new JButton("Place Flag");
		//The button for uncovering
		JButton uncoverSelect = new JButton("Uncover Tile");
		//The button for selecting
		JButton selectSelect = new JButton("Highlight Tiles");
		
		//Create listeners for each button
		SelectionListener uncoverListens = new SelectionListener(1, mouse);
		uncoverSelect.addActionListener(uncoverListens);
		SelectionListener flagListens = new SelectionListener(2, mouse);
		mineSelect.addActionListener(flagListens);
		SelectionListener selectListens = new SelectionListener(3, mouse);
		selectSelect.addActionListener(selectListens);
		
		//Update field listens to add mouse
		//It'll be automatically on uncover
		mouse.setIsUncover(true);
		fListen.setMouse(mouse);
		
		//The button for clearing highlights
		JButton clearHighlights = new JButton("Clear Highlights");
		//I'll add the action listener later when I have the panel array
		
		//The visible counters for how many mines are left
		JLabel remainder = new JLabel(" "+mines+" ");
		//Make a fun font
		Font font = new Font("Dialog", Font.BOLD, 26);
		remainder.setFont(font);
		remainder.setBackground(new Color(209, 228, 232));
		fListen.setLeft(remainder);
		
		//The button for retrying
		JButton retry = new JButton("Retry Map");
		//Make the listener
		RetryListener retryListens = new RetryListener(tilearr, mines, frame);
		retry.addActionListener(retryListens);
		
		//The new game button
		JButton newGame = new JButton("New Game");
		//Make the listener
		NewGameButtonListener ngbListens = new NewGameButtonListener(frame);
		newGame.addActionListener(ngbListens);
		
		//Add everything
		menu.add(mineSelect);
		menu.add(uncoverSelect);
		menu.add(selectSelect);
		menu.add(remainder);
		menu.add(clearHighlights);
		menu.add(retry);
		menu.add(newGame);
		
		
		//------------------------------Field---------------------------------
		
		//Make the grid layout for the mines
		mineField.setSize((int)frameWidth, smallRes-100);
		mineField.setLayout(new GridLayout(rows, columns));
		
		//Create the imageIcon
		ImageIcon hiddenTileImg = createIcon(getClass().getResource("Assets/hiddenTile.png"), 
				(int) (((mineField.getWidth()/columns))-((mineField.getWidth()/columns)*.1)));
		
		//Make labels for each tile and make them hidden tile assets
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				//Make a button and panel
				JButton hiddenTile = new JButton();
				JPanel currentPanel = new JPanel(new GridLayout(0, 1));
				currentPanel.add(hiddenTile);
				
				//Create the action event for uncovering
				hiddenTile.addMouseListener(fListen);
				hiddenTile.setIcon(hiddenTileImg);
				
				//Add the panel to the panel array
				panelArr[i][j] = currentPanel;
				
				//Add it all together
				currentPanel.add(hiddenTile);
				mineField.add(currentPanel);
			}
		}
		//Update the field listener
		fListen.setPanelArr(panelArr);
		fListen.setMap(tilearr);
		fListen.setWindow(frame);
		
		//Finally add the clearHighlights action listener
		ClearListener clear = new ClearListener(tilearr, panelArr, frame);
		clearHighlights.addActionListener(clear);
		
		//Add the panels to the frame
		container.add(menu);
		container.add(mineField);
		frame.add(container);
		
		//Set it to visible
		frame.setVisible(true);
	}
	
	//-------------------------------------------------------------------------------
	
	
	

	//------------------------------New Game Window--------------------------------
	//Make a window to create a new game
	public void makeNewGameWindow() {
		
		//Create a frame
		Window frame = new Window();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 1));
		frame.setSize(300, 150);
		
		//Make a container and set a layout
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		//Make fields
		//The field for rows
		JFormattedTextField enterRows = new JFormattedTextField("Rows");
		enterRows.setPreferredSize(new Dimension (200, 50));
		
		//The field for columns
		JFormattedTextField enterColumns = new JFormattedTextField("Columns");
		enterColumns.setPreferredSize(new Dimension (200, 50));
		
		//And mines
		JFormattedTextField enterMines = new JFormattedTextField("Mines");
		enterMines.setPreferredSize(new Dimension (200, 50));
		
		//Make a go button
		JButton go = new JButton("New Game");
		//Make a new action listener instance
		NewGameListener listens = new NewGameListener(enterRows, enterColumns, enterMines, frame);
		go.addActionListener(listens);
		
		//Add it all together
		container.add(enterRows);
		container.add(enterColumns);
		container.add(enterMines);
		container.add(go);
		frame.add(container);
		frame.setVisible(true);
	}
	
	//------------------------------------------------------------------------------
	
	//----------------------------Error Window--------------------------------------
	//This is in case the user inputs something that cannot be processed
	//when making a new game
	public void makeErrorWindow(int errorValue) {
		//We'll have a window with a single label
		Window frame = new Window();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300, 200);
		JLabel message = null;
		
		//Error value 1 is if there is no number in the text field
		if (errorValue == 1) {
			message = new JLabel("Input must be a integer");
		}
		//Error value 2 is if the mine count is higher than the tile count
		else if (errorValue == 2) {
			message = new JLabel("Mine count must be less than tile count");
		}
		//Error value 3 is for if anything less than 0 is inputed, or any value over 255
		else if (errorValue == 3) {
			message = new JLabel("Rows and columns must have a width between 3 and 20."
					+ "\nMine count must be between 1 and 399.");
		}
		else {
			message = new JLabel("You broke it.");
		}
		
		//Add the label to the frame and make it visible
		frame.add(message);
		frame.setVisible(true);
		
	}
	
	//---------------------------------------------------------------------------------
	
	//----------------------Game Over Window--------------------------------------------
	
	//This is the window when a game ends
	//A new game or a retry can be created, or just quit
	public void makeGameOverWindow(int code, int mines, Tile[][] arr, Window oldWindow) {
		//I'm importing a code so I can use basically the same window for a win
		//loss or new game
		//Make a new window
		Window frame = new Window();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(100, 300);
		//Managing the layout
		frame.setLayout(new GridLayout(1, 0));
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(0, 1));
		
		//Make the corresponding text blurbs
		JLabel message = null;
		
		//A 1 is a new game with no losses or wins
		if (code == 1) {
			message = new JLabel("NEW GAME");
		}
		//A 2 is a game over
		else if (code == 2) {
			message = new JLabel("GAME OVER!");
		}
		//A 3 is a win
		else if (code == 3) {
			message = new JLabel("YOU WON!");
		}
		//Otherwise it'll just be blank
		else {
			message = new JLabel("");
		}
		
		message.setSize(200, 200);
		
		//Make a retry, new game, and quit button
		JButton retry = new JButton("Retry");
		JButton newGame = new JButton("New Game");
		JButton quit = new JButton("Quit");
		
		//Add the retry listener
		RetryListener retryListens = new RetryListener(arr, mines, oldWindow);
		retry.addActionListener(retryListens);
		
		//As an additional note, if this is the first game, nothing can be retried
		if (code == 1) {
			retry.setEnabled(false);
		}
		
		//Add the new game action listener
		NewGameButtonListener ngbListens = new NewGameButtonListener(oldWindow);
		newGame.addActionListener(ngbListens);
		
		//Add the quit ActionListener
		QuitListener quitListens = new QuitListener();
		quit.addActionListener(quitListens);
		
		//Add it all together
		container.add(message);
		container.add(retry);
		container.add(newGame);
		container.add(quit);
		frame.add(container);
		
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}
	
	
	
}
