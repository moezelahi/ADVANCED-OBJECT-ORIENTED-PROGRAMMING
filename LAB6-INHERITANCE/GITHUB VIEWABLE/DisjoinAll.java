
public class DisjoinAll extends ExpressionCollector {
	DisjoinAll() {
		super();
		defaultValue = "false";
		operator = "||";
	}
	
	void evaluate() { // assumption isTypeCorrect
		boolean result = false;
		for(int i = 0; i < noe; i ++) {
			Expression e = expressions[i];
			e.evaluate();
			result = result || (Boolean) e.getValue();
		}
		value = result;
	}
}
