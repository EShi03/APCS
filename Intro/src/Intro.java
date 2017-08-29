
public class Intro {
	//Main method for printing out the results of the methods
	public static void main(String[] args){
		System.out.println(ret());
		System.out.println(logic(true,true,true));
		System.out.println(stars(5));
		System.out.println(coins(7));
		
	}
	//ret() is a method that returns 17
	public static int ret(){
		return 17;
	}
	//logic() is a method that takes three booleans and returns the combination of them
	public static boolean logic(boolean a, boolean b, boolean c){
		return a&b&c;
	}
	//stars() takes an int and makes that many number of rows with incrementing number of stars using a double nested loop
	public static String stars(int n){
		String retval = "";
		for(int i = 0; i<n; i++){
			for(int j = n-i; j<=n; j++){
				retval = retval.concat("*");
			}
			retval = retval.concat("\n");
		}
		return retval;
	}
	//coins takes an int and returns the minimum amount of coins in nickels and 2 cent coins or -1 if it isn't possible
	//I checked to see if the amount was divisible by 5 and 2. If not, I would return -1.
	//Then I made the amount divisible by 5 through subtracting amount%5 form amount
	//and divided it by 5, which equals the number of nickels
	//Then I did (n%5)/2 = number of 2 cent coins
	//then I added the amount of nickels and 2 cent coins together and returned that value
	public static int coins(int n){
		int leftover = 0;
		int numCoins = 0;
		if((n%5)%2 == 0){
			leftover = n - n%5;
			numCoins += leftover/5;
			numCoins += (n%5)/2;
			return numCoins;
		}
		return -1;
	}
}
