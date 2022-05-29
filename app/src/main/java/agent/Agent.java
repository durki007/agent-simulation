package agent;

import simulation.Organisation;
import utils.Position;
import weapon.Weapon;

public class Agent {
    private Position position;
    private Weapon weapon;
    private Integer hp;
    private Integer speed;
    private Organisation organisation;

    public Agent() {

    }

    public Agent(Position position, Organisation organisation) {
        this.position = position;
        this.organisation = organisation;
    }

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

    public Position getPosition() {
        return this.position;
    }

    public Organisation getOrganisation() {
        return organisation;
    }
}
