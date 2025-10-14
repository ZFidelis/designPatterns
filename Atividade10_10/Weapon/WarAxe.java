import java.util.List;

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
        return false; // logica de permissao para equipar
    }

    @Override
    public void attack(Character attacker, List<Character> targets) {
        System.out.println("atacado"); // logica para dano
    }
}
