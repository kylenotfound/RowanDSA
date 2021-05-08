package tree;

/**
 * Result of subracting two expr
 * @author Kyle Evangelisto
 */
public class Difference extends Expr {
	
	public Difference(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() - right.eval();
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if((right instanceof Constant) && (left instanceof Constant)) {
			return new Constant(left.eval() - right.eval());
		}
		if((right instanceof Constant) && right.eval() == 0) { //x-0=x
			return left;
		}
		if(right.equals(left)) {
			return new Constant(0);
		}
		return this;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Difference)) {
			return false;
		}
		Difference other = (Difference) obj;
		return left.equals(other.left) && right.equals(other.right);
	}
	
	public String toString() {
		return "(" + left + " - " + right + ")";
	}
}
