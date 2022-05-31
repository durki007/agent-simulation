package engine;

import java.util.ArrayList;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import agent.Agent;
import simulation.Board;

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
        for (int i = 0; i < matrix.length; i++) {
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
            matrix[agent.getPosition().x][agent.getPosition().y] = EngineUtils.getAgentString(agent);
        }
        return matrix;
    }

    // TODO: Printing to .txt file
    public static void renderStats(Board board, Integer timeFrame) {
        System.out.println("Finished with stats: (stats), at time: " + timeFrame);
    }

    // Temporary helper functions
    private static void printAgents(Board board) {
        for (Agent agent : board.agents) {
            System.out.println(agent + " " + agent.getOrganisation() + " (" + agent.getPosition().x + ", "
                    + agent.getPosition().y + ") " + agent.getHp() + " " + agent.type);
            // System.out.println(Ansi.ansi().bold().fg(Ansi.Color.BLUE).a("Hello").reset().toString());
            // System.out.println(Ansi.ansi().render("@|red Hello|@"));
            // System.out.println("\033[34mhhhh");
        }
    }
}
