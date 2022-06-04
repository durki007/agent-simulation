package engine;

import java.util.ArrayList;

import org.fusesource.jansi.Ansi;

import agent.Agent;
import simulation.Board;
import simulation.Organisation;

public class Engine {
    public static void render(Board board, Integer timeFrame) {
        // Render board
        // System.out.println("Time: " + timeFrame);
        // System.out.println(board);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        printAgents(board);
        printMatrix(createMatrix(board.n, board.m, board.agents));
    }

    // FIXME: Fix direction of matrix
    private static void printMatrix(String[][] matrix) {
        System.out.print("      ");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(Ansi.ansi().fg(Ansi.Color.YELLOW).a(String.format(" %3d  ", i)).reset().toString());
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(Ansi.ansi().fg(Ansi.Color.YELLOW).a(String.format(" %3d  ", i)).reset().toString());
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static String[][] createMatrix(int n, int m, ArrayList<Agent> agents) {
        String matrix[][] = new String[n][m];
        String spacer = " ... ";
        // Fill with '.'
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = spacer;
            }
        }
        // Print agents
        for (Agent agent : agents) {
            if (agent.isAlive())
                matrix[agent.getPosition().x][agent.getPosition().y] = EngineUtils.getAgentString(agent);
        }
        return matrix;
    }

    // TODO: Printing to .txt file
    public static void renderStats(Board board, Integer timeFrame) {
        System.out.println("Finished with stats: (stats), at time: " + timeFrame);
        for (Organisation organisation : board.stats.getDmgDealt().keySet()) {
            System.out.println(organisation);
            System.out.println(String.format("%f %d", organisation, board.stats.getDmgDealt().get(organisation)));
        }
    }

    // Temporary helper functions
    private static void printAgents(Board board) {
        for (Agent agent : board.agents) {
            System.out.println(agent + " " + agent.getOrganisation() + " (" + agent.getPosition().x + ", "
                    + agent.getPosition().y + ") " + agent.getHp() + " " + agent.type);
        }
    }
}
