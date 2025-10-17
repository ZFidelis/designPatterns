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
            break;
        }
    }

    public void specialAttack(Character attacker, List<Character> targets) {
        Weapon weapon = attacker.equippedWeapon;
        
        if (weapon == null) {
            System.out.println("Impossível atacar sem uma arma equipada");
            return;
        }

        SpecialAttack spAtk = weapon.specialAttack();

        for (Character target : targets) {
            if (spAtk.statusEffect != null) {
                int roll = random.nextInt(100);
                if (roll < spAtk.statusEffectChance) {
                    target.setStatusEffect(spAtk.statusEffect);
                    System.out.println("Efeito de " + spAtk.statusEffect + " foi aplicado no inimigo: " + target.name);
                }
            }
            target.hp = target.hp - weapon.getBaseDamage();
            if (!spAtk.isAoE) {
                System.out.println("Ataque Especial bem sucedido!");
                break;
            }
        }
    }

    public void enemyAttack(Character attacker, Character target) {
        int damage = attacker.strength;
        target.hp = target.hp - damage;

        System.out.println(attacker.name + " causou " + damage + " no " + target.name);

        if (target.hp <= 0) {
            System.out.println("O " + target.name + " morreu!");
        }
    }
}
