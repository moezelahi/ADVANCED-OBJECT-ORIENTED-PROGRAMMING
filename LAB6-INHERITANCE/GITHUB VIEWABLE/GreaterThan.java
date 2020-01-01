
public class GreaterThan extends Expression {
	GreaterThan(int left, int right) {
		super(left, right);
	}
	
	void evaluate() {
		value = left > right;
	}
	
	public String toString() {
		return left + " > " + right;
 	}
}
