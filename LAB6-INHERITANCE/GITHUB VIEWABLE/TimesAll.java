
public class TimesAll extends ExpressionCollector {
	TimesAll() {
		super();
		defaultValue = "1";
		operator = "*";
	}
	
	void evaluate() { // assumption isTypeCorrect
		int result = 1;
		for(int i = 0; i < noe; i ++) {
			Expression e = expressions[i];
			e.evaluate();
			result *= (Integer) e.getValue();
		}
		value = result;
	}
}
