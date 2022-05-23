package agent;

import weapon.RifleWeapon;
import weapon.Weapon;

public class BasicAgent extends Agent {
    private Integer hp = 75;
    private Integer speed = 2;
    private Weapon weapon;

    BasicAgent() {
        this.weapon = new RifleWeapon();
    }
}
