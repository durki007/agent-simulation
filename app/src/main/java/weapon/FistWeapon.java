package weapon;

import java.util.Random;



public class FistWeapon implements Weapon {
    final int BASE_DMG = 20;
    final int INACCURACY = 0;

    public int calculateDamage() {
        return BASE_DMG;
    }
}
