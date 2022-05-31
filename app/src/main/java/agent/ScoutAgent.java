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
        super(position, organisation, 50, 3, new RifleWeapon());
        type = AgentType.SCOUT;
    }
}