package tree;

/**
 * Result of mod of two expr
 * @author Kyle Evangelisto
 */
public class Mod extends Expr {
	
	public Mod(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() % right.eval();
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if(left instanceof Constant && right.eval() > left.eval()) {
			return left;
		}
		if(left instanceof Constant && right.eval() == 0) {
			return null;
		}
		if(left instanceof Constant && right.eval() == 1) {
			return new Constant(0);
		}
		return this;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Mod)) {
			return false;
		}
		Mod other = (Mod) obj;
		return left.equals(other.left) && right.equals(other.right);
	}
	
	public String toString() {
		return "(" + left + " % " + right + ")";
	}
}