
public class Conjunction extends LogicalSentence{
	
	//constructor for conjucation which is a subclass of logical sentence
	public Conjunction(LogicalSentence logSen1, LogicalSentence logSen2){
		super(conjugate(logSen1, logSen2));
	}
	
	//getting the boolean value of conjugating two logical sentences
	//but I only kept the value and not both logical sentences
	private static LogicalSentence conjugate(LogicalSentence logSen1, LogicalSentence logSen2){
		if(logSen1.getPropCont().getBol() && logSen2.getPropCont().getBol()){
			logSen1.getPropCont().setBol(true);
			return logSen1;
		}
		logSen1.getPropCont().setBol(false);
		return logSen1;
	}
}
