
public class main {
	//code in the main method was given
	//However, my code does nothing because I can not determine what some method should do
	//These include: evaluate and findMatch. TruthTable also doesn't work
	//but I believe I am suppose to print out a truth table using a logical sentence
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4));

		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b,true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

		String[] pc = {"p"};
		truthTable(pc);
	}
	//Legal is a method to check if a string is a legal logical sentence
	static boolean legal(String str){
		//checking to see if the last character is an operator and returning false if it is
		if(isLogicOperator(str.substring(str.length()-1))){
			return false;
		}
		//long lengthy method that could probably be shortened
		for(int i = 0; i<str.length()-1; i++){
			//bol is a switch boolean for the edge case of "!" because it is in front of the propositional constant
			//instead of behind it
			boolean bol = true;
			if(bol){
				//checks if the even characters are letters that represent propositional constants
				if(i%2 == 0){
					if(!isChar(str.substring(i, i))){
						return false;
					}
					//changes the bol if a "!" is there otherwise the loop will see the letter that represents the propositional constant
					//and think that it is suppose to be a logical operator
					else if(str.substring(i, i).equals("!")){
						bol = false;
					}
				}
				else {
					//checks that odd characters are logical operators
					if(!isLogicOperator(str.substring(i, i))){
						return false;
					}
				}
			}
			//after the switch, odd characters are expected to be letters and even characters are expected to be logical operators
			else {
				if(i%2 == 1){
					if(!isChar(str.substring(i, i))){
						return false;
					}
					//Switch back in case there are more "!"
					else if(str.substring(i, i).equals("!")){
						bol = true;
					}
				}
				else {
					if(!isLogicOperator(str.substring(i, i))){
						return false;
					}
				}
			}
			
		}
		//if the loop doesn't find anything wrong, it will return true
		return true;
	}
	//helper method of checking to see if a character is one of the different logical operators
	private static boolean isLogicOperator(String str) {
		String[] logOp = {"^", "v", "=>", "<=>"};
		for(int i = 0; i<logOp.length-1; i++){
			if(str.equals(logOp[i])){
				return true;
			}
		}
		return false;
	}
	//helper method of checking to see if a character is one of a letter that represents a propatitional constant
	private static boolean isChar(String str){
		String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","p","w","x","y","z"};
		for(int i = 0; i<letters.length-1; i++){
			if(str.equals(letters[i])){
				return true;
			}
		}
		return false;
	}
	//I could not think of what this method could do
	//probably something along the lines of: if this logical sentence is found at this index(?) then return true, else false
	static boolean findMatch(String str, int i){
		return true;
	}
	//Prints out a truthtable of a logical sentence
	//I just don't think I did the helper methods right, so I couldn't print out anything
	static void truthTable(String[] str){
		
	}
}
