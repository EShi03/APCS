
public class PropositionConstant {
	private String name;
	private boolean bol;
	
	//constructor of the proposition constant value
	public PropositionConstant(String name){
		this.name = name;
	}
	
	//getter for the name
	public String getName(){
		return this.name;
	}
	
	//getter for the boolean
	public boolean getBol(){
		return this.bol;
	}
	
	//setter for the boolean
	public void setBol(boolean bol){
		this.bol = bol;
	}
	
	
}
