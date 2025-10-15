public class ArcaneStaff implements Weapon {
    String name = "Cajado Arcano";
    int baseDamage = 8;
    int manaCost = 25;


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
        if (user.intelligence < 12) {
            System.out.println("Mana insuficiente para equipar essa arma!");
            return false;
        }
        return true;
    }
}
