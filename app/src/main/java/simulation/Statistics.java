package simulation;

import java.io.FileWriter;
import java.util.ArrayList;
import agent.Agent;
import com.rits.cloning.Cloner;

public class Statistics {

    private ArrayList<Board> boards;

    public Statistics() {
        this.boards = new ArrayList<Board>();
    }

    public void gather(Board board) {
        Cloner cloner = new Cloner();
        Board clone = cloner.deepClone(board);
        this.boards.add(clone);

        // System.out.println("Gathered:" + board);
    }

    public void save(String filepath) {
        final String spacer = "    ";
        System.out.println("Saving to file: " + filepath);
        ArrayList<String> lines = new ArrayList<String>();
        int t = 0;
        for (Board board : this.boards) {
            lines.add(String.format("Time: %d", t));
            for (Organisation o : Organisation.values()) {
                lines.add(String.format("%s :", o));
                ArrayList<Agent> orgAgents = board.getAgents();
                orgAgents.removeIf(a -> a.getOrganisation() != o);
                for (Agent a : orgAgents) {
                    lines.add(String.format("%s %s HP: %d", spacer, a.type, a.getHp()));
                }
            }
            lines.add("");
            t++;
        }
        saveToFile(filepath, lines);
    }

    private void saveToFile(String filepath, ArrayList<String> lines) {
        try {
            FileWriter f = new FileWriter(filepath);
            for (String l : lines) {
                f.write(l + "\n");
            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
