package tree;

/**
 * Result of dividing two expr
 * @author Kyle Evangelisto
 */
public class Quotient extends Expr {
	
	public Quotient(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() / right.eval();
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(left instanceof Constant && right.eval() == 0) {
			return null;
		}
		if(right instanceof Constant && left.eval() == 0) {
			return new Constant(0);
		}
		if(left instanceof Constant && right.eval() == 1) {
			return left;
		}
		if(left.equals(right)) {
			return new Constant(1);
		}
		return this;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Quotient)) {
			return false;
		}
		Quotient other = (Quotient) obj;
		return left.equals(other.left) && right.equals(other.right); 
	}
	
	public String toString() {
		return "(" + left + " / " + right + ")";
	}

}
