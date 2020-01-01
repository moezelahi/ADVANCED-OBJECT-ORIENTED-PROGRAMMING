
public class Expression {
	protected int left;
	protected int right;
	
	protected Object value;
	
	Expression(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	Expression(Expression other) {
		this.left = other.left;
		this.right = other.right;
	}
	
	int getLeft() {
		return left;
	}
	
	int getRight() {
		return right;
	}
	
	Object getValue() {
		return value;
	}
	
	void evaluate() {
		
	}
}
