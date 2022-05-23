package agent;

import simulation.Organisation;
import utils.Position;
import weapon.Weapon;

public class Agent {
    private Position position;
    private Weapon weapon;
    private Integer hp = 75;
    private Integer speed = 2;
    private Organisation organisation;

    public Position getNextMove() {
        // rng
        return new Position(0, 0);
    }

    public void move(Position pos) {
        this.position = pos;
    }

    public boolean isAlive() {
        return true;
    }

    public void iniflictDamage() {

    }

    public Integer getDamage() {
        // rng
        return 0;
    }
}
