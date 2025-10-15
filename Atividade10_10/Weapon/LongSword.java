public class LongSword implements Weapon {
    String name = "Espada Longa";
    int baseDamage = 15;
    int manaCost = 0;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public boolean canEquip(Character user) {
        if (user.strength < 10) {
            System.out.println("Força insuficiente para equipar essa arma!");
            return false;
        }
        return true;
    }
}
