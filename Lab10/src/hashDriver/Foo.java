package hashDriver;
public class Foo {

    private int x;
    private char ch;
    private String s;
    private String name;

    public Foo(int x, char ch, String s, String name){
        this.x = x;
        this.ch = ch;
        this.s = s;
        this.name = name;
    }

    public char getCh() {
        return ch;
    }

    public int getX() {
        return x;
    }

    public String getName() {
        return name;
    }

    public String getS() {
        return s;
    }

    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof Foo)){
            return false;
        }
        Foo other = (Foo) obj;
        return x == other.x && ch == other.ch && s.equals(other.s);
    }

    @Override
    public int hashCode() {
        return getS().hashCode() + getName().hashCode();
    }
}
