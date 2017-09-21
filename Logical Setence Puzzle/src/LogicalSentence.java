
public class LogicalSentence {
	private PropositionConstant propCont;
	private LogicalSentence logSen;
	
	//constructor to create a logical sentence with a proposition constant and a logical sentence
	public LogicalSentence(PropositionConstant propCont, LogicalSentence logSen){
		this.propCont = propCont;
		this.logSen = logSen;
	}
	
	//constructor to create a logical sentence with only a logical sentence
	public LogicalSentence(LogicalSentence logSen){
		this(logSen.getPropCont(), logSen);
	}
	
	//constructor to create a logical sentence with only a proposition constant
	//This is where I feel like I am doing something wrong and potentially getting myself into an
	//infinate loop of making classes
	public LogicalSentence(PropositionConstant propCont){
		this.propCont = propCont;
	}
	
	//getter for propCont
	public PropositionConstant getPropCont(){
		return this.propCont;
	}
	
	//getter for logical sentence
	public LogicalSentence getLogicalSentence(){
		return this.logSen;
	}
	
	//I don't know what evalute is suppose to be
	//probably the boolean value of the a logical sentence and a truth assignment,
	//but i don't know what the truth assignment's value is.
	boolean evaluate(TruthAssignment t){
		return true;
	}
}
