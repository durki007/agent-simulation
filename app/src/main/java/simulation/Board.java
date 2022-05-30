package simulation;

import java.util.ArrayList;
import java.util.Random;

import agent.Agent;
import agent.BasicAgent;
import agent.ScoutAgent;
import utils.Position;

public class Board {
    // Size
    public int n; // X-Coordinate
    public int m; // Y-Coordinate
    // List
    public ArrayList<Agent> agents;

    // Size constructor
    public Board(int n, int m) {
        this.n = n;
        this.m = m;
    }

    // Populate
    //TODO: typeRatio is not used
    public void populate(int gangSize, ArrayList<Integer> typeRatio) {
        System.out.println("Populating the board");
        agents = new ArrayList<Agent>();
        for (Organisation o : Organisation.values()) {
            for (int i = 0; i < gangSize; i++) {
                agents.add(new BasicAgent(findVacantPosition(), o));
                agents.add(new ScoutAgent(findVacantPosition(), o));
            }
        }
    }

    // Move all agents
    // TODO: Handle when there is no move to make
    // TODO: Checking if agent is alive
    public void move() {
        for (Agent agent : agents) {
            Position pos = agent.getNextMove();
            while (!isPositionVacant(pos)) {
                pos = getRandomPosition();
            }
            agent.move(pos);
        }
        System.out.println("After move: ");
    }

    // Fight mechanics
    public void fight() {

    }

    // Helper functions

    // TODO: Handle error, when no free position is left
    private Position findVacantPosition() {
        Position pos = getRandomPosition();
        while (!isPositionVacant(pos)) {
            pos = getRandomPosition();
        }
        return pos;
    }

    private Boolean isPositionVacant(Position pos) {
        // Bound check
        if (pos.x > n || pos.x < 0)
            return false;
        if (pos.y > m || pos.y < 0)
            return false;
        // Vacancy check
        Boolean checker = true;
        for (Agent agent : agents) {
            if (agent.getPosition() == pos)
                checker = false;
        }
        return checker;
    }

    private Position getRandomPosition() {
        Random rand = new Random();
        int x = rand.nextInt(this.n);
        int y = rand.nextInt(this.m);
        return new Position(x, y);
    }
}
