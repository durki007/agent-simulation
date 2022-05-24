package engine;

import simulation.Board;

public class Engine {
    public static void render(Board board, Integer timeFrame) {
        System.out.println("Time: " + timeFrame);
        System.out.println(board);
    }

    public static void renderStats(Board board, Integer timeFrame) {
        System.out.println("Finished with stats: (stats), at time: " + timeFrame);
    }
}
