package tree;

/**
 * An expr tree is an arithmetic expression
 * @author Kyle Evangelisto
 */
public abstract class Expr {
    Expr left, right;

    //public Expr(Expr left, Expr right) {
    //    this.left = left;
    //    this.right = right;
    //}

    /**
     * @return the value of this Expr
     */
    public abstract int eval();

    /**
     * @return true iff this expr is the same as the given obj
     */
    public abstract boolean equals(Object obj);

    /**
     * @return a simplified version of this expr if possible
     */
    public abstract Expr simplify();

}
