import java.util.List;

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
        return false; // logica de permissao para equipar
    }

    @Override
    public void attack(Character attacker, List<Character> targets) {
        if(manaCost > attacker.mp) {
            System.out.println(attacker.name + " não tem mana o suficiente para exercer o ataque!");
            return;
        }
        
    }
}
