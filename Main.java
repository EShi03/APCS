
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
		int position = (int)((Math.random()*(grid.length-2))+1);
		position = closestOpenPositionOuterArray(position, grid);
		int position2 = (int)((Math.random()*(grid.length-2))+1);
		position2 = closestOpenPositionInnerArray(position, position2, grid);
		grid[position][position2] = "+";
	}

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

	private static void fenceSetUp(String[][] grid) {
		fencePerimeterSetUp(grid);
		fenceRandomsSetUp(grid);
	}

	private static void fenceRandomsSetUp(String[][] grid) {
		for(int a = 0; a < 20; a++){
			int position = (int)((Math.random()*(grid.length-2))+1);
			position = closestOpenPositionOuterArray(position, grid);
			int position2 = (int)((Math.random()*(grid.length-2))+1);
			position2 = closestOpenPositionInnerArray(position, position2, grid);
			grid[position][position2] = "F";
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
	
	private static boolean isRowFull(int row, String[][] grid){
		for(int i = 1; i < grid[row].length-1; i++){
			if(grid[row][i] == " "){
				return false;
			}
		}
		return true;
	}

	
	
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
}
