package sort;

public class main {

	public static void main(String[] args) {
		
		//test int array
		int[] num = {5, 1, 3, 9, 8 ,3, 4, 5};
		
		//printing out values of bubble sort
		for(int i = 0; i < num.length; i++) {
			System.out.print(bubbleSort(num)[i]);
		}
		
		//spacing
		System.out.println(" ");
		
		//printing out values of insertion sort
		for(int i = 0; i < num.length; i++) {
			System.out.print(insertionSort(num)[i]);
		}
		
		//spacing
		System.out.println(" ");
		
		//printing out values of selection sort
		for(int i = 0; i < num.length; i++) {
			System.out.print(selectionSort(num)[i]);
		}
		
	}
	
	private static int[] bubbleSort(int[] num) {
		
		//return value
		int[] retval = num;
		
		// int to store a value
		int holder;
		
		//double nested loop that checks if one value of retval is bigger than the next, if so then swap them
		// double nested loop ensures that it goes through the whole array
		for(int i = 0; i < num.length-1; i++) {
			for(int j = 0; j < num.length-1; j++) {
				if(retval[i] > retval[i+1]) {
					holder = retval[i];
					retval[i] = retval[i+1];
					retval[i+1] = holder;
				}
			}
		}
		return retval;
	}
	
	
	private static int[] insertionSort(int[] num) {

		//return value
		int[] retval = num;
		
		// int to store selected value
		int holder;
		
		// int to store a value
		int holder2;
		
		//double nested loop that checks if one value of retval is bigger than the next after the selected value, if so then swap the values
		// double nested loop ensures that it goes through the whole array
		//there is an error in this one because I don't know how to insert the selected value in a loop while only doing it once
		for(int i = 0; i < num.length-1; i++) {
			for(int j = 0; j < i; j++) {
				if(retval[i] <= retval[j]) {
					holder = retval[i];
					holder2 = retval[j+1];
					retval[j+1] = retval[j];
					retval[j] = holder2;
				}
			}
		}
		return retval;
		
	}
	
	
	private static int[] selectionSort(int[] num) {

		//return value
		int[] retval = num;
		
		// int to store a value
		int holder;
		
		// int to store the position of the minimum value in the unsorted array
		int minPos;
			
		for(int i = 0; i < num.length-1; i++) {
			
			//finds the minimum value in the unsorted array
			if(retval[i] < retval[i+1]) {
				minPos = i;
			}
			else {
				minPos = i+1;
			}
			//code that switches the minimum value and the value of the beginning of the unsorted array
			holder = retval[i];
			retval[i] = retval[minPos];
			retval[minPos] = holder;
		}
		return retval;
	}
}

