package recursion;

/**
 *
 * @author Kyle Evangelisto
 */
public class Recursion {

    /** @return the quotient when x is divided by y.
     *	Pre:   x and y are both positive
     */
    public static int div (int x, int q) {
        if(x <= q) {
            return 1;
        }
        return div(x - q, q) + 1;
    }

    public static int mod (int x, int y) {
        if (x < y) {
            return x;
        } else {
            return mod(x-y, y);
        }
    }

    public static void main(String ... args) {
        System.out.println("99 divided recursively by 11 is: " + div(99,11));
        System.out.println(mod(12, 11));
    }
}
