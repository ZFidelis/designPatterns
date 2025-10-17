import StatusEffect.Stun;

public class HolyHammer implements Weapon {
    String name = "Martelo Sagrado";
    int baseDamage = 14;
    int manaCost = 20;


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
        if (user instanceof Paladin) {
            return true;
        }
        System.out.println("Você não é digno de equipar essa arma!");
        return false;
    }

    @Override
    public SpecialAttack specialAttack() {
        return new SpecialAttack(this.baseDamage, false, new Stun(), 50);
    }
}
