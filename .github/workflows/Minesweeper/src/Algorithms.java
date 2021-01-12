
//Imports
import java.util.Random;
import java.util.Date;


/*This class holds all the algorithm methods, such as
 * mine randomization, getting the state of blocks, etc.*/

public class Algorithms {
	
	//-----------------------------Creating a window----------------------------------------
	
	//I'm using a 2D array of tile objects to keep track of the data
	public Tile[][] createMap(int rows, int columns){
		//First I will map a 2D array
		Tile[][] map = new Tile[rows][columns];
		System.out.println("The dimensions are "+map.length+", "+map[0].length);
		//Then I'll fill it with blank tiles that will be corrected later
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				//Create a new tile object then assign it to the space
				//It has the values: isMine false, isOpen false, isBlank true, value = 10
				//The value is 10 because that would never occur when placing mines
				//Therefore if any value is 10, the map needs to be made
				Tile currentTile = new Tile(false, false, false, 10, false);
				map[i][j] = currentTile;
			}
		}
		return map;
	}
	
	//-----------------------------------------------------------------------------------------
	
	
	
	//--------------------------Calculating and placing mines-----------------------------------
	
	//Here I will be calculating and placing mines on the map in a random fashion.
	
	public Tile[][] positionMines(Tile[][] map, int mineCount, int noX, int noY){
		//I'm creating an array of random numbers for the mine locations
		//An array will help make sure there are no repeats
		int[] randomNum = new int[mineCount];
		
		//I'm using the date to get a random number
		Random rand = new Random();
		Date date = new Date();
		//This will be the coordinate where the mine goes
		int slot;
		//These will hold the seed
		long lseed = 1;
		int seed = 0;
		//I'm also setting an isRepeat boolean to track repeats and the already
		//opened tile
		boolean isInvalid = true;
		//To simplify things, I'm making row and column variables
		int rows = map.length;
		int columns = map[0].length;
		
		
		//We'll do this loop for however many mines there are
		for (int i = 0; i < mineCount; i++) {
			
			//Set the seed
			lseed = date.getTime();
			seed = (int)lseed;
			//This if statement is a safety net in case the number is negative
			if (seed <= 0) {
				seed *= -1;
				seed++;
			}
			
			//This finds a number within the confines of the map
			slot = 0;
			
			
			//Make a while loop to check for repeats
			while (isInvalid) {
				slot = rand.nextInt((int)seed)%(rows*columns);
				//Just double check that the slot isn't already taken
				//We'll assume isInvalid is false now
				isInvalid = false;
				//Go through the randomNum array
				for(int j = 0; j < randomNum.length; j++) {
					if(slot == randomNum[j] || (noX == (slot) % rows &&
							noY == (slot-((j) % rows))/columns)) {
						//If there still is a repeat or the slot is the same
						//isInvalid is true
						System.out.println("There was repeat");
						isInvalid = true;
					}
				}
				
				//Reset the random number in case there is a repeat
				if (isInvalid) {
					lseed = date.getTime();
					seed = (int)lseed;
					if (seed <= 0) {
						seed *= -1;
						seed++;
					}
				}
			}
			//Reset isRepeat
			isInvalid = true;
			
			//After we are sure there is no repeat, add the value to randomNum
			randomNum[i] = slot;
		}
		
		System.out.println("\n\nThe length of the array is: "+randomNum.length+"\n\n\n");
		
		//Now I'm going to place those mines on the field
		//I'm looping through the randomNumber array
		for (int i = 0; i < randomNum.length; i++) {
			//The first thing to do is to find the x and y coordinates of the mine
				//instead of just a place number
			int xCoor = (randomNum[i]) % (rows);
			System.out.println("This mine's x coord is "+xCoor);
			int yCoor = (randomNum[i]-xCoor)/columns;
			System.out.println("This mine's y coord is "+yCoor);
			
			
			//Now I can place the mine by updating the tile at that location to isMine
			map[yCoor][xCoor].setIsMine(true);
			map[yCoor][xCoor].setValue(9);
			System.out.println("A mine was placed at: "+xCoor+", "+yCoor);
		}
		
		//Finally, return the map
		//Print out all the stuff
				for (int i = 0; i < map.length; i++) {
					System.out.println("\n-----------Row "+(i+1)+"----------\n");
					for (int j = 0; j < map[i].length; j++) {
						System.out.println(map[i][j].toString()+"\n");
					}
				}
		return map;
		
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	
	
	//----------------------------------------Correcting markers----------------------------------------------
	
	//Here I will be correcting the blank tiles to reflect the correct values
	public Tile[][] placeNum(Tile[][] map){
		//I'm making a variable to count mines around each tile
		int mines = 0;
		
		
		//We'll go through a for loop to identify each space
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				//I'm only looking at non-mine tiles
				if (!map[i][j].getIsMine()) {
					
					//I have to use two more for loops to work around the tile
					//Note I'm starting at negative 1 and going to 1 so I can add k and l to
					//the current location to get an offset
					for (int k = -1; k<=1; k++) {
						for (int l = -1; l<=1; l++) {
							//Now we can count mines
							//Also need to make sure we aren't at the edge
							if(i+k>=0 && j+l>=0 && i+k<map.length && j+l<map[i].length) {
								//And that k and j both aren't 0
								if (!(k==0 && l == 0)) {
									if(map[i+k][j+l].getIsMine()) {
										mines++;
									}
								}
							}
						}
					}
					//Now we'll set the tile value to the number of mines
					map[i][j].setValue(mines);
					//And reset the number of mines
					mines = 0;
					}
				System.out.print("["+map[i][j].getValue()+"] ");
				}
			System.out.println();
			}
		
		
		//Return the map at the end
		return map;
		
		
	}
	
	//---------------------------------------------------------------------------------------------------		
	
	
	
	
	
	
}

