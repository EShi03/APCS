
public class Main {
	public static void main(String[] args){
		String[][] grid = new String[12][12];
		testSetUp(grid);
		setBoard(grid);
		print(grid);
	}
	
	private static void testSetUp(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				grid[i][j] = " ";
			}
		}
	}

	private static void print(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println(" ");
		}
		
	}

	private static void setBoard(String[][] grid){
		fenceSetUp(grid);
		mhoSetUp(grid);
		mainCharSetUp(grid);
	}

	private static void mainCharSetUp(String[][] grid) {
		int position1 = (int)(Math.random()*9.0);
		int position2 = (int)(Math.random()*9.0);
		if(grid[position1+1][position2+1].equals(" ")){
			grid[position1+1][position2+1] = "+";
		}	
	}

	private static void mhoSetUp(String[][] grid) {
		String[] mhoNames = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c"};
		for(int i = 0; i < mhoNames.length; i++){
			int position1 = (int)(Math.random()*9.0);
			int position2 = (int)(Math.random()*9.0);
			if(grid[position1+1][position2+1].equals(" ")){
				grid[position1+1][position2+1] = mhoNames[i];
			}
			else {
				i -= 1;
			}
		}
	}

	private static void fenceSetUp(String[][] grid) {
		fencePerimeterSetUp(grid);
		fenceRandomsSetUp(grid);
	}

	private static void fenceRandomsSetUp(String[][] grid) {
		for(int i = 0; i < 20; i++){
			int position1 = (int)(Math.random()*9.0);
			int position2 = (int)(Math.random()*9.0);
			if(grid[position1+1][position2+1].equals(" ")){
				grid[position1+1][position2+1] = "F";
			}
			else {
				i -= 1;
			}
		}
	}

	private static void fencePerimeterSetUp(String[][] grid) {
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[i].length; j++){
				if(j == 0 || j == grid[i].length-1 || i == 0 || i == grid.length-1){
					grid[i][j] = "F";
				}
			}
		}
		
	}
	
	
}
