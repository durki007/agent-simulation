package agent;

import utils.Position;
import simulation.Organisation;
import weapon.RifleWeapon;
import weapon.Weapon;

public class BasicAgent extends Agent {
    private Integer hp;
    private Integer speed;
    private Weapon weapon;

    public BasicAgent() {
        super();
    }

    public BasicAgent(Position position, Organisation organisation) {
        super(position, organisation);
        this.hp = 75;
        this.speed = 2;
        this.weapon = new RifleWeapon();
    }
}