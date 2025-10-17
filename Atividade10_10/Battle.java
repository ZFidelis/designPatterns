import java.util.List;
import java.util.Random;

public class Battle {

    public Random random = new Random();

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

    public void specialAttack(Character attacker, List<Character> targets) {
        Weapon weapon = attacker.equippedWeapon;
        SpecialAttack spAtk = weapon.specialAttack();
        for (Character target : targets) {
            if (spAtk.statusEffect != null) {
                // precisa usar a chance de aplicar o status
                int roll = random.nextInt(1);
                target.setStatusEffect(spAtk.statusEffect);
            }
        }
    }
}
