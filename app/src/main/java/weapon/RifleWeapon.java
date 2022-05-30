package weapon;

import java.util.Random;

public class RifleWeapon implements Weapon {
    final int BASE_DMG = 40;
    final int INACCURACY = 10;
    public int calculateDamage() {

        Random rand = new Random();
        int maxDmg = BASE_DMG + INACCURACY;
        int minDmg = BASE_DMG - INACCURACY;
        return rand.nextInt(maxDmg - minDmg +1) + minDmg;
    }
}
