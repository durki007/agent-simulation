package weapon;

import java.util.Random;

public class PistolWeapon implements Weapon {
    final int BASE_DMG = 30;
    final int INACCURACY = 5;
    public int calculateDamage() {

        Random rand = new Random();
        int maxDmg = BASE_DMG + INACCURACY;
        int minDmg = BASE_DMG - INACCURACY;
        return rand.nextInt(maxDmg - minDmg +1) + minDmg;
    }
}
