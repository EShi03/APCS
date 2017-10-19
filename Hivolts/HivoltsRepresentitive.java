import javax.swing.JApplet;

public class HivoltsRepresentitive{
	//creates an empty 12by12 string array to represent the game board
	//and runs helper methods to set the board up, fill it with blanks, and printing the grid out
	private static String[][] grid = new String[12][12];
	public static void main(){
		fillBlank(grid);
		setBoard(grid);
		//print(grid);
	}
	
	//fills the null-filled string array with spaces
	private static void fillBlank(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				grid[i][j] = " ";
			}
		}
	}
	
	//prints out the board
	private static void print(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println(" ");
		}
		
	}
	
	//runs helper methods for fence, mho, and main character set ups
	private static void setBoard(String[][] grid){
		fenceSetUp(grid);
		mhoSetUp(grid);
		mainCharSetUp(grid);
	}

	//gets the x and y position by using math.random to get a number between 1 and 10
	//gets the nearest x and y position that is open
	//sets that open x and y position to be "+", representing the main character
	private static void mainCharSetUp(String[][] grid) {
		int position = (int)((Math.random()*(grid.length-2))+1);
		position = closestOpenPositionOuterArray(position, grid);
		int position2 = (int)((Math.random()*(grid.length-2))+1);
		position2 = closestOpenPositionInnerArray(position, position2, grid);
		grid[position][position2] = "+";
	}

	//uses a loop to yet open random positions for mhos
	private static void mhoSetUp(String[][] grid) {
		String[] mhoNames = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c"};
		for(int i = 0; i < mhoNames.length; i++){
			int position = (int)((Math.random()*(grid.length-2))+1);
			position = closestOpenPositionOuterArray(position, grid);
			int position2 = (int)((Math.random()*(grid.length-2))+1);
			position2 = closestOpenPositionInnerArray(position, position2, grid);
			grid[position][position2] = mhoNames[i];
		}
	}

	//helper method to run two helper methods: one to set up the parameter fences and
	//one to set up the random fences within the board
	private static void fenceSetUp(String[][] grid) {
		fencePerimeterSetUp(grid);
		fenceRandomsSetUp(grid);
	}

	//uses math.random to get a number between 1-10 and sets that position to "F" to represent a fence
	private static void fenceRandomsSetUp(String[][] grid) {
		for(int a = 0; a < 20; a++){
			int position = (int)((Math.random()*(grid.length-2))+1);
			position = closestOpenPositionOuterArray(position, grid);
			int position2 = (int)((Math.random()*(grid.length-2))+1);
			position2 = closestOpenPositionInnerArray(position, position2, grid);
			grid[position][position2] = "F";
		}
	}
	
	//uses a double loop to set all the edges of the 12by12 grid to "F"
	private static void fencePerimeterSetUp(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				if(j == 0 || j == grid[i].length-1 || i == 0 || i == grid.length-1){
					grid[i][j] = "F";
				}
			}
		}
		
	}
	
	//helper method to determine if a row is full or isn't filled with spaces
	private static boolean isRowFull(int row, String[][] grid){
		for(int i = 1; i < grid[row].length-1; i++){
			if(grid[row][i] == " "){
				return false;
			}
		}
		return true;
	}

	
	//finds the closest open position for columns
	private static int closestOpenPositionOuterArray(int row, String[][] grid){
		int closestPosForward = 0;
		int closestPosBackward = 0;
		for(int j = row; j < grid.length-1; j++){
			if(!isRowFull(j, grid)){
				closestPosForward = j;
				break;
			}
		}
		for(int i = row; i > 0; i--){
			if(!isRowFull(i, grid)){
				closestPosBackward = i;
				break;
			}
		}
		if(closestPosForward >= closestPosBackward){
			return closestPosBackward;
		}
		return closestPosForward;
	}
	
	//finds the closest open position within a row
	private static int closestOpenPositionInnerArray(int position1, int position2, String[][] grid){
		int closestPosForward = 1;
		int closestPosBackward = 1;
		for(int j = position2; j < grid[position1].length-1; j++){
			if(grid[position1][j] == " "){
				closestPosForward = j;
				break;
			}
		}
		for(int i = position2; i > 0; i--){
			if(grid[position1][i] == " "){
				closestPosBackward = i;
				break;
			}
		}
		if(closestPosForward >= closestPosBackward){
			return closestPosBackward;
		}
		return closestPosForward;
	}
	
	//used to get the final randomized grid 
	public static String[][] getGrid(){
		return grid;
	}
}
