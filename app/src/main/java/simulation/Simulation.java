/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package simulation;

import engine.Engine;
import utils.RatioUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Simulation {

    private Board board;
    private Integer duration; // Liczba tur
    private Integer time; // Aktualna ture

    public Simulation(int n, int m, int duration, int gangSize) {
        this.board = new Board(n, m);
        this.duration = duration;
        // Populate board
        board.populate(gangSize, RatioUtils.getRatio());
        // Set time to 0
        this.time = 0;
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

    public void printStats() {
        // Wypisz koniec na stoud
        Engine.renderStats(board, time);
        // Wypisz statytki na stdout i do pliku
    }

    public static void main(String[] args) {
        // TODO Parse args
        // Create new simulation
        Simulation simulation = new Simulation(10, 10, 10, 10);
        // Start the simulation
        simulation.run();
        // Print stats
        simulation.printStats();
    }
}
