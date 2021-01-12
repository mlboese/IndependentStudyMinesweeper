
//This is an object class to keep track of counters to see if the game is over
public class Counters {
	
	//Create the variables
	int marked;
	int covered;
	int total;
	
	public Counters(int m, int c, int t) {
		//Marked is the amount of mines marked
		marked = m;
		//Covered is the amount of correctly marked mines
		covered = c;
		//Total is how many mines need to be covered
		total = t;
	}
	
	//--------------------------Get and Set Methods--------------------------------
	//Marked
	public int getMarked() {
		return marked;
	}
	public void setMarked(int newMarked) {
		marked = newMarked;
	}
	
	//Covered
	public int getCovered() {
		return covered;
	}
	public void setCovered(int newCovered) {
		covered = newCovered;
	}
	
	//Total
	public int getTotal() {
		return total;
	}
	public void setTotal(int newTotal) {
		total = newTotal;
	}
	
	//To String
	public String toString() {
		return ("Marked: "+marked+" | Covered: "+covered+" | Total: "+total);
	}
	
}
