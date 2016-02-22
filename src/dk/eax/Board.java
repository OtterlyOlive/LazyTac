package dk.eax;

import java.util.ArrayList;

/**
 * Created by eax on 18/02/16.
 */
public class Board {
    ArrayList<Field> board = new ArrayList<Field>();

    public Board() {}

    public ArrayList<Field> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Field> board) {
        this.board = board;
    }
}
