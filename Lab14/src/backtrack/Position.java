package backtrack;

/**
 * A position is a row and a column number on a chess board
 * Row and column numbers begin at 0
 * @author Kyle Evangelisto
 */
public class Position {

    private int row, col;

    public Position (int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Position)) {
            return false;
        }
        Position other = (Position) obj;
        return row == other.row && col == other.col;
    }

    /**
     * @return true iff a queen on this position
     * is attacking a queen on the other position
     */
    public boolean isAttacking (Position other) {
        return row == other.row ||
                col == other.col ||
                row + col == other.row + other.col ||   //major
                row - col == other.row - other.col;     //minor
    }


}
