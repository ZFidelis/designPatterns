public class ShadowDagger implements Weapon {
    String name = "Adaga Sombria";
    int baseDamage = 10;
    int manaCost = 10;


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
        if (user.dexterity < 12) {
            System.out.println("Destreza insuficiente para equipar essa arma!");
            return false;
        }
        return true;
    }
}
