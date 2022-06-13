/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package simulation;

import engine.Engine;
import org.apache.commons.cli.*;
import utils.RatioUtils;

import java.util.concurrent.TimeUnit;

public class Simulation {

    private Board board;
    private Integer duration; // Liczba tur
    private Integer time; // Aktualna ture
    private Statistics stats;

    public Simulation(int n, int m, int duration, String newRatio) {
        this.board = new Board(n, m);
        this.duration = duration;
        this.stats = new Statistics();
        // Populate board
        board.populate(RatioUtils.getRatio(newRatio));
        // Set time to 0
        this.time = 0;
        Engine.render(board, time);
    }

    public void run() {
        // Main loop
        while (time < duration) {
            // Move all agents
            board.move();
            // Fight
            board.fight();
            // Render board
            Engine.render(board, time);
            // Statistics
            stats.gather(board);
            // Wait some time
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            time++;
        }
    }

    public void printStats(String filepath) {
        stats.save(filepath);
    }

    public static void main(String[] args) {
        Options options = new Options();
        Option n = new Option("n", "nDim", true, "n - dimension of board");
        n.setRequired(true);
        options.addOption(n);

        Option m = new Option("m", "mDim", true, "m - dimension of board");
        m.setRequired(true);
        options.addOption(m);

        Option d = new Option("d", "duration", true, "Duration of the simulation");
        d.setRequired(true);
        options.addOption(d);

        Option r = new Option("r", "ratio", true, "Gang member ratio in format: (basic,scout,tank) ");
        r.setRequired(true);
        options.addOption(r);

        Option f = new Option("f", "file", true, "filename");
        r.setRequired(true);
        options.addOption(f);


        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Required flags:", options);
            System.exit(1);
            return;
        }
        int newN = Integer.parseInt(cmd.getOptionValue("n"));
        int newM = Integer.parseInt(cmd.getOptionValue("m"));
        int newDuration = Integer.parseInt(cmd.getOptionValue("d"));
        String newRatio = cmd.getOptionValue("r");
        String newFileName = cmd.getOptionValue("f");

        // Create new simulation
        Simulation simulation = new Simulation(newN, newM, newDuration, newRatio);
        // Start the simulation
        simulation.run();
        // Print stats
        simulation.printStats(newFileName);
    }
}
