import StatusEffect.Stun;

public class ElvenBow implements Weapon {
    String name = "Arco Élfico";
    int baseDamage = 12;
    int manaCost = 15;

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
        if (user.dexterity < 8) {
            System.out.println("Destreza insuficiente para equipar essa arma!");
            return false;
        }
        return true;
    }

    @Override
    public SpecialAttack specialAttack() {
        return new SpecialAttack(this.baseDamage, true, null, 0);
    }
}
