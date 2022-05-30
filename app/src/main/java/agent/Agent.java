package agent;

import java.util.Random;

import simulation.Organisation;
import utils.Position;
import weapon.PistolWeapon;
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
        // Default values
        this.weapon = new PistolWeapon();
        this.hp = 75;
        this.speed = 2;
    }

    // Generates potential position
    // WARNIG: Generated position can be invalid
    // TODO: Cuurent aproach is invalid, because Agent jump by 0 squares (end up in
    // starting position after move)
    public Position getNextMove() {
        Position tmpPosition = this.position;
        Random rand = new Random();
        for (int i = 0; i < this.speed; i++) {
            Integer XorY = rand.nextInt(2); // 0-1
            Integer PorM = rand.nextInt(2); // 0-1
            if (XorY == 1) {
                if (PorM == 1)
                    tmpPosition.x++;
                else
                    tmpPosition.x--;
            } else {
                if (PorM == 1)
                    tmpPosition.y++;
                else
                    tmpPosition.y--;
            }
        }
        return tmpPosition;

    }

    public void move(Position pos) {
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
        // TODO: Damage rng
        return 5;
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
}
