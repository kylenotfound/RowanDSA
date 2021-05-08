package backtrack;

/**
 * Find a solution to the N queens problem, if possible.
 * How can N queens be placed on an NxN board such that
 * no two queens are attacking each other.
 * @author Kyle Evangelisto
 */
public class EightQueens {
    public static final int SIZE = 8;

    public static void main (String ... args) {
        EightQueens game = new EightQueens();
        //place queens in col 0 using this board
        System.out.println(game.placeQueens(0, new Board()));
        /* for (int i = 1; i < 31; i++) {
            System.out.println("Generating for size: " + (i));
            System.out.println(game.placeQueens(0, new Board()));
            System.out.println();
            SIZE ++;
        }*/
    }

    /**
     * Pre: Given a board b, on which queens have been safely
     * placed in columns 0 .. col - 1
     * @param col
     * @param b
     * @return a new Board on which queens have been safely
     * placed on all columns, or null if not possible
     */
    private Board placeQueens (int col, Board b) {
        Position p;
        Board result;

        if (col == SIZE) {
            return b;
        }

        for (int row = 0; row < SIZE; row++) {
            p = new Position(row, col);
            result = new Board(b);
            result.addQueen(p);
            if (result.ok()) {
                result = placeQueens(col + 1, result);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

}
