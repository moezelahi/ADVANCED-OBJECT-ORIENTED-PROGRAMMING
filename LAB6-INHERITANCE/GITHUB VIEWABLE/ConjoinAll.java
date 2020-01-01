
public class ConjoinAll extends ExpressionCollector {
	ConjoinAll() {
		super();
		defaultValue = "true";
		operator = "&&";
	}
	
	void evaluate() { // assumption isTypeCorrect
		boolean result = true;
		for(int i = 0; i < noe; i ++) {
			Expression e = expressions[i];
			e.evaluate();
			result = result && (Boolean) e.getValue();
		}
		value = result;
	}
}
