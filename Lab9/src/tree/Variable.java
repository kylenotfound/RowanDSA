package tree;

/**
 * Represents a variable
 * Kyle Evangelisto
 */
public class Variable extends Expr {

	private char name; //variable has a name x, y, a, b etc
    public int value; //the value assigned to variable
    boolean assigned = false; //is the variable assigned?

	public Variable(char name) {
		this.name = name;
	}

	public Variable (char name, Constant value) {
	    this.name = name;
    }

	public int eval() {
        if(!assigned) {
            throw new IllegalArgumentException();
        }
        return value;
	}

    /**
     * If obj is not a variable, return false
     * If the object's name passed in matches this variables name return true
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Variable)) {
            return false;
        }
        Variable variable = (Variable) obj;
        return ((Character)(this.name)).equals((Character) variable.name);

    }

    public Expr simplify() {
		return this;
	}

	public String toString() {
        return "" + this.name;
    }

    public void set(int value) {
        this.value = value;
        assigned = true;
    }



}
