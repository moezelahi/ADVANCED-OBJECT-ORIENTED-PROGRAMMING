
public class ExpressionCollector {
	protected Expression[] expressions;
	protected int noe;
	protected Object value;
	protected String defaultValue;
	protected String operator;
	
	ExpressionCollector() {
		expressions = new Expression[10];
	}
	
	void addExpression(Expression e) {
		expressions[noe] = e;
		noe++;
	}
	
	void addExpression(int left, String op, int right) {
		Expression e;
		if(op.equals("+")) {
			e = new Addition(left, right);
		}
		else if(op.equals("-")) {
			e = new Subtraction(left, right);
		}
		else if(op.equals("*")) {
			e = new Multiplication(left, right);
		} 
		else if(op.equals("==")) {
			e = new Equal(left, right);
		}
		else if(op.equals(">")) {
			e = new GreaterThan(left, right);
		}
		else if(op.equals("<")) {
			e = new LessThan(left, right);
		}
		else {
			e = null;
		}
		addExpression(e);
	}
	
	boolean isArithmetic(Expression e) {
		return 
				e instanceof Addition 
			||	e instanceof Subtraction
			|| 	e instanceof Multiplication;
	}
	
	boolean isRelation(Expression e) {
		return 
				e instanceof Equal 
			||	e instanceof GreaterThan
			|| 	e instanceof LessThan;
	}
	
	boolean isTypeCorrect() {
		if(this instanceof AddAll || this instanceof TimesAll) {
			for(int i = 0; i < noe; i ++) {
				if(!isArithmetic(expressions[i])) {
					return false;
				}
			}
			return true;
		}
		else {
			for(int i = 0; i < noe; i ++) {
				if(!isRelation(expressions[i])) {
					return false;
				}
			}
			return true;
		}
	}
	
	Object getValue() {
		return value;
	}
	
	Expression[] getExpressions() {
		Expression[] exps = new Expression[noe];
		for(int i = 0; i < noe; i ++) {
			exps[i] = expressions[i];
		}
		return exps;
	}
	
	void evaluate() {
		
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		ExpressionCollector other = (ExpressionCollector) obj;
		if(this.isTypeCorrect() && other.isTypeCorrect()) {
			this.evaluate();
			other.evaluate();
			return this.getValue().equals(other.getValue());
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String s = "";
		if(noe == 0) {
			s = defaultValue;
		}
		else {
			s += defaultValue + " " + operator + " ";
			for(int i = 0; i < noe; i ++) {
				s += "(" + expressions[i] + ")";
				if(i < noe - 1) {
					s += " " + operator + " ";
				}
			}	
		}
		return s;
	}
}
