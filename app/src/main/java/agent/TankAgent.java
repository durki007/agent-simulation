package agent;

import simulation.Organisation;
import utils.Position;
import weapon.RifleWeapon;
import weapon.Weapon;

public class TankAgent extends Agent {

    public Integer hp;
    public Integer speed;
    public Weapon weapon;

    public TankAgent() {
        super();
    }

    public TankAgent(Position position, Organisation organisation) {
        super(position, organisation);
        this.hp = 100;
        this.speed = 1;
        this.weapon = new RifleWeapon();
    }
}
