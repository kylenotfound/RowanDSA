package tree;

public class Assign extends Expr {

    public Assign(Expr var, Expr value) {
        super.left = var;
        super.right = value;
        if (!(var instanceof Variable)) {
            throw new IllegalArgumentException();
        }
        ((Variable) var).set(value.eval());
    }

    @Override
    public int eval() {
        return right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Assign)) {
            return false;
        }
        Assign other = (Assign) obj;
        return (left.equals(other.left) && right.equals(other.right));
    }

    @Override
    public Expr simplify() {
        return right;
    }

    public String toString() {
        return "(" + this.left + " = " + this.right.eval() + ")";
    }
}
