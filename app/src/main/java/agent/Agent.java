package agent;

import java.util.Random;

import simulation.Organisation;
import utils.Position;
import weapon.Weapon;

public class Agent  {
    private Position position;
    private Weapon weapon;
    private Integer hp;
    private Integer speed;
    private Organisation organisation;
    public AgentType type;

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
        return this.hp > 0;
    }

    public boolean isInRange(Position pos) {
        int dX = Math.abs(this.position.x - pos.x);
        int dY = Math.abs(this.position.y - pos.y);
        return (dX <= 1 && dY <= 1) && (dX + dY != 0); // If pos == this.pos return false
    }

    public void inflictDamage(int dmg) {
        this.hp -= dmg;
    }

    public int getDamage() {
        return weapon.calculateDamage();
    }

    public Position getPosition() {
        return this.position;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public Integer getHp() {
        return this.hp;
    }

    @Override
    public Agent clone() {
        try {
            Agent clone = (Agent) super.clone();
            clone.organisation = this.organisation;
            clone.hp = this.hp;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
