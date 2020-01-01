
public class AddAll extends ExpressionCollector {
	AddAll() {
		super();
		defaultValue = "0";
		operator = "+";
	} 
	
	void evaluate() { // assumption isTypeCorrect
		int result = 0;
		for(int i = 0; i < noe; i ++) {
			Expression e = expressions[i];
			e.evaluate();
			result += (Integer) e.getValue();
		}
		value = result;
	}
}
