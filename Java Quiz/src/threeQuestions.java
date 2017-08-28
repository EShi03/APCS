import java.util.Scanner;


public class threeQuestions {
	public static void main(String[] args){
		// input is a scanner object that allows the programmer to input, in this case, strings to the program"
		Scanner input = new Scanner(System.in);
		//These three strings are the questions that will be printed to the screen for the programmer to answer"
		String question1 = "What is the constructor of an instance *bob* of the class *Boy*?";
		String question2 = "What is the method that prints out a line? Print out *I like potatoes* (Use * instead of quotes)";
		String question3 = "What is the scope of an instance variable? Assume that the instance variable was created within private method Calculate. Answer with *The scope of the instance variable is within...*";
		//These three strings are the answers that will be compared to the answers that the programmer inputs to see if it is correct"
		String answer1 = "Boy bob = new Boy();";
		String answer2 = "System.out.println(*I like potatoes*);";
		String answer3 = "The scope of the instance varible is within Calculate";
		//runQuestion is run three times, one for each question
		runQuestion(question1, answer1, input);
		runQuestion(question2, answer2, input);
		runQuestion(question3, answer3, input);
		//input.close() is a method to shut down the scanner object. I put it here because if you don't there is a yellow error saying like "information leaking" or something
		input.close();
	}
	/*The method runQuestion() takes 2 strings and a scanner object. It prints out the question
	  Then the programmer inputs a string. That string is then stored into an instance variable
	  Then the instance variable is compared to the answer string and prints out "correct" or "wrong"
	  based on if the answers matched or not*/
	private static void runQuestion(String question, String answer, Scanner input){
		System.out.println(question);
		String answer_input = input.nextLine();
		if(answer_input.equals(answer)){
			System.out.println("Correct");
		}
		else{
			System.out.println("Wrong");
		}
	}
}
