package agent;

import simulation.Organisation;
import utils.Position;
import weapon.FistWeapon;
import weapon.Weapon;

public class TankAgent extends Agent {

    public Integer hp;
    public Integer speed;
    public Weapon weapon;

    public TankAgent() {
        super();
    }

    public TankAgent(Position position, Organisation organisation) {
        super(position, organisation, 100, 1, new FistWeapon());
        type = AgentType.TANK;
    }
}
