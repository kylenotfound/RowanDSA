package tree;

/**
 * An expr which is the sum of two expr
 * @author Kyle Evangelisto
 */
public class Sum extends Expr{

    public Sum (Expr left, Expr right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        return left.eval() + right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Sum)) {
            return false;
        }
        Sum other = (Sum) obj;
        return left.equals(other.left) && right.equals(other.right) ||
                left.equals(other.right) && right.equals(other.left);
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.eval() == 0) {
            return right;
        }
        if (right instanceof Constant && right.eval() == 0) {
            return left;
        }
        return this;
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}
