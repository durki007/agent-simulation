package simulation;

import java.util.ArrayList;
import java.util.HashMap;

public class Statistics {

    private ArrayList<Board> boards;

    public Statistics() {
        this.boards = new ArrayList<Board>();
    }

    public void gather(Board board) {
        this.boards.add(board);
    }

    public void save(String filepath) {

    }

}
