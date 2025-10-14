import java.util.List;

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
        return false; // logica de permissao para equipar
    }

    @Override
    public void attack(Character attacker, List<Character> targets) {
        System.out.println("atacado"); // logica para dano
    }
}
