package agent;

import java.util.Currency;
import java.util.Random;

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

    public Agent(Position position, Organisation organisation, Integer hp, Integer speed, Weapon weapon) {
        this.position = position;
        this.organisation = organisation;
        this.hp = hp;
        this.speed = speed;
        this.weapon = weapon;
    }

    // Generates potential position
    // TODO: Solve that agent can move back to the same position
    public Position getNextMove() {
        Position tmpPosition = this.position;
        Random rand = new Random();
        for (int i = 0; i < this.speed; i++) {
            Integer XorY = rand.nextInt(2); // 0-1
            Integer PorM = rand.nextInt(2); // 0-1
            if (XorY == 1) {
                if (PorM == 1) {
                    tmpPosition = new Position(tmpPosition.x + 1, tmpPosition.y);
                    // tmpPosition.x++;
                } else {
                    tmpPosition = new Position(tmpPosition.x - 1, tmpPosition.y);
                    // tmpPosition.x--;
                }
            } else {
                if (PorM == 1) {
                    tmpPosition = new Position(tmpPosition.x, tmpPosition.y + 1);
                    // tmpPosition.y++;
                } else {
                    tmpPosition = new Position(tmpPosition.x, tmpPosition.y - 1);
                    // tmpPosition.y--;
                }
            }
        }
        // System.out.println("Current: " + position.serialize() + " Proposed: " +
        // tmpPosition.serialize());
        return tmpPosition;

    }

    public void move(Position pos) {
        // System.out.println("Moving agent by a distance of: " +
        // this.position.distance(pos));
        this.position = pos;
    }

    public boolean isAlive() {
        return true;
    }

    public void inflictDamage() {

    }

    public Integer getDamage() {
        // rng
        return 0;
    }

    public Integer getHp() {
        return this.hp;
    }

    public Position getPosition() {
        return this.position;
    }

    public Organisation getOrganisation() {
        return organisation;
    }
}
