package backtrack;

import list.*;

/**
 * A board has a List of Positions, on which there are queens.
 * @author Kyle Evangelisto
 */
public class Board {

    //Positions on which there are queens
    List<Position> queens = new ArrayList<>(EightQueens.SIZE * EightQueens.SIZE);

    public Board () {
        //queens = new ArrayList<>();
    }

    public Board (Board board) {
        //queens = new ArrayList<Position>(board.queens); //Not working! >:(
        Iterator<Position> iterator = board.queens.iterator();
        while (iterator.hasNext()) {
            queens.add(iterator.next());
        }
    }

    /* Place a queen on position p of this board */
    public void addQueen (Position p) {
        queens.add(p);
        //System.out.println(toString());
    }

    public boolean ok() {
        Position p, other;
        for (int i = 0; i < queens.size() - 1; i++) {
            p = queens.get(i);
            for (int j = i + 1; j < queens.size(); j++ ) {
                other = queens.get(j);
                if (p.isAttacking(other)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < EightQueens.SIZE; row++) {
            for (int col = 0; col < EightQueens.SIZE; col++) {
                if (queens.contains(new Position(row, col))) {
                    result.append(" Q ");
                } else {
                    result.append(" . ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
