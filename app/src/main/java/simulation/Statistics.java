package simulation;

import java.util.ArrayList;
import java.util.HashMap;

public class Statistics {
    private HashMap<Organisation, Integer> dmgDealt;

    public Statistics() {
        // initialize
        this.dmgDealt = new HashMap<Organisation, Integer>();
        for (Organisation o : Organisation.values()) {
            dmgDealt.put(o, 0);
        }
    }

    public HashMap<Organisation, Integer> getDmgDealt() {
        return this.dmgDealt;
    }

    void dmg(Organisation org, Integer dmg) {
        dmgDealt.replace(org, dmgDealt.get(org) + dmg);
    }
}
