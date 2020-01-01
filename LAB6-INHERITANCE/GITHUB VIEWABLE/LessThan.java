
public class LessThan extends Expression {
	LessThan(int left, int right) {
		super(left, right);
	}
	
	void evaluate() {
		value = left < right;
	}
	
	public String toString() {
		return left + " < " + right;
 	}
}
