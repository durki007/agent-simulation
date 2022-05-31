package agent;

import utils.Position;
import simulation.Organisation;
import weapon.RifleWeapon;
import weapon.Weapon;

public class BasicAgent extends Agent {
    public Integer hp;
    public Integer speed;
    public Weapon weapon;

    public BasicAgent() {
        super();
    }

    public BasicAgent(Position position, Organisation organisation) {
        super(position, organisation, 75, 2, new RifleWeapon());
    }
}
