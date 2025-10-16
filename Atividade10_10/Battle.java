import java.util.List;

public class Battle {
    String targetsName;

    public void attack(Character attacker, List<Character> targets) {
        Weapon weapon = attacker.equippedWeapon;

        if (weapon == null) {
            System.out.println("Impossível atacar sem uma arma equipada");
            return;
        }

        int damage = weapon.getBaseDamage();
        for (Character target : targets) {
            if (this.targetsName == null) {
                this.targetsName = target.name;
            }
            else {
                this.targetsName = this.targetsName + ", " + target.name;
            }

            target.hp = target.hp - damage;
            System.out.println("A arma " + weapon.getName() + " causou " + weapon.getBaseDamage() + " de dano no inimigo: " + target.name);

            if (target.hp <= 0) {
                System.out.println("O inimigo: " + target.name + " morreu!");
            }
            System.out.println("\n");
        }
    }

    public void calculateStatusEffect() {
        
    }
}
