package tree;

/**
 * A constant is an Expr which has a value
 * @author Kyle Evangelisto
 */
public class Constant extends Expr {
    int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Constant)) {
            return false;
        }
        Constant constant = (Constant) obj;
        return value == constant.value;
    }

    @Override
    public Expr simplify() {
        return this;
    }

    public String toString() {
        return "" + value;
    }
}
