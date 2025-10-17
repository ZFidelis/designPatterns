import StatusEffect.Stun;

public class WarAxe implements Weapon {
    String name = "Machado de Guerra";
    int baseDamage = 18;
    int manaCost = 5;


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
        if (user.strength < 15) {
            System.out.println("Força insuficiente para equipar essa arma!");
            return false;
        }
        return true;
    }

    @Override
    public SpecialAttack specialAttack() {
        return new SpecialAttack(this.baseDamage, false, new Stun(), 25);
    }
}
