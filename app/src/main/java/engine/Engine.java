package engine;

import agent.Agent;
import simulation.Board;

public class Engine {
    public static void render(Board board, Integer timeFrame) {
        System.out.println("Time: " + timeFrame);
        System.out.println(board);
        printAgents(board);
    }
    //TODO: Printing to .txt file
    public static void renderStats(Board board, Integer timeFrame) {
        System.out.println("Finished with stats: (stats), at time: " + timeFrame);
    }

    // Temporary helper functions
    private static void printAgents(Board board) {
        for (Agent agent : board.agents) {
            System.out.println(agent + " " + agent.getOrganisation() + " (" + agent.getPosition().x + ", "
                    + agent.getPosition().y + ")");
        }
    }
}
