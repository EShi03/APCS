package mapcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class main {
	
	public static void main(String[] args) {
		//arraylist as my input list into mapcar
		List<Object> test = new ArrayList<Object>();
		
		//two test cases, one for toUpCase and one for sqr (squaring the number)
		test.addAll(Arrays.asList("hello", "bed", "sleep"));
		//test.addAll(Arrays.asList(1, 2, 3, 4, 5));
		
		//loop to print out the return arraylist of mapcar
		for(int i = 0; i < test.size(); i++) {
			System.out.println(mapcar(main::toUpCase, test).get(i));
		}
	}
	
	private static List<Object> mapcar(Function<Object, Object> function, List<Object> arg1) {
		
		//retval of type list to return the modified lists
		List<Object> retval = new ArrayList<Object>();
		
		//loop to go through all objects of the list
		for(int i = 0; i < arg1.size(); i++) {
			
			//try and catch to see if the types of the method and list elements are compatible because
			//Any list of objects and any type of method can be passed through
			//try block tries to run the function with the current element of the input list and then adds it
			//to retval
			try {
				retval.add(function.apply(arg1.get(i)));
			}
			catch(RuntimeException e) {
				retval.add("Wrong Object for this method");
				return retval;
			}
		}
		//returns the modified list
		return retval;
	}
	
	//method #1 (have to type cast because any object can be passed in)
	private static String toUpCase(Object str) {
		return ((String) str).toUpperCase();
	}
	
	//method #2 (have to type cast because any object can be passed in)
	private static Integer sqr(Object num) {
		Integer retval = ((Integer)num)*((Integer)num);
		return retval;
	}
}
