
public class Equal extends Expression {
	Equal(int left, int right) {
		super(left, right);
	}
	
	void evaluate() {
		value = left == right;
	}
	
	public String toString() {
		return left + " == " + right;
 	}
}
