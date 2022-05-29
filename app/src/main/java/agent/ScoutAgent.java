package agent;

import simulation.Organisation;
import utils.Position;
import weapon.RifleWeapon;
import weapon.Weapon;

public class ScoutAgent extends Agent {
    public Integer hp;
    public Integer speed;
    public Weapon weapon;

    public ScoutAgent() {
        super();
    }

    public ScoutAgent(Position position, Organisation organisation) {
        super(position, organisation);
        this.hp = 50;
        this.speed = 3;
        this.weapon = new RifleWeapon();
    }
}