
public class Negation extends LogicalSentence{
	
	//constructor for negation that is a subclass of LogicalSentence
	public Negation(LogicalSentence logSen){
		super(negate(logSen));
	}
	
	//class method to change the boolean value of a logical sentence's propositional constant to its opposite value
	public static LogicalSentence negate(LogicalSentence logSen){
		logSen.getPropCont().setBol(!(logSen.getPropCont().getBol()));
		return logSen;
	}
}
