package simulation;

import java.util.ArrayList;
import java.util.Random;

import agent.Agent;
import agent.BasicAgent;
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
    public void populate(int gangSize, ArrayList<Integer> typeRatio) {
        System.out.println("Populating the board");
        agents = new ArrayList<Agent>();
        for (Organisation o : Organisation.values()) {
            for (int i = 0; i < gangSize; i++) {
                agents.add(new BasicAgent(findVacantPosition(), o));
            }
        }
        // Tworzy agentów
        printAgents();
    }

    // Move all agents
    public void move() {

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

    // Temporary helper functions
    private void printAgents() {
        for (Agent agent : agents) {
            System.out.println(agent + " " + agent.getOrganisation() + " (" + agent.getPosition().x + ", "
                    + agent.getPosition().y + ")");
        }
    }
}
