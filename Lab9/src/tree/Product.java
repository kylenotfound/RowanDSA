package tree;

/**
 * Result of multiplying two expr
 * @author Kyle Evangelisto
 */
public class Product extends Expr {
	
	public Product(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() * right.eval();
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		/*Quiz 5 Question 1 **/
		if ((left instanceof Quotient) && (right instanceof Quotient)) {
			/*
			  If left is (a / b) of the product and right is (b / c) (If left and right are Quotients)
			   (a / b)  <= x		a  /  b    *    b  /  c
			   (b / c)  <= y		  left 			 right
			   (x) * (y)		 left <|> right	  left <|> right
			   So where x's left or left.left and y's right or right.right
			   Return a new Quotient => a / c
			   This was my thought process though, it may not be correct to have it i simplify,
			   but make its own special Simplify two quotients method, but this is all I could really think of
			   in time.
			 */
			return new Quotient(left.left, right.right);
		}
		/*end Quiz 5 Question 1 **/
		if(right instanceof Constant && right.eval() == 1) {
			return left;
		}
		if(left instanceof Constant && left.eval() == 1) {
			return right;
		}
		if(right instanceof Constant && right.eval() == 0) {
			return right;
		}
		if(left instanceof Constant && left.eval() == 0) {
			return left;
		}
		return this;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		return left.equals(other.left) && right.equals(other.right) || 
				left.equals(other.right) && right.equals(other.left); 
	}
	
	public String toString() {
		return "(" + left + " * " + right + ")";
	}
}
