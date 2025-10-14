import java.util.List;

public interface Weapon {
    String getName();
    int getBaseDamage();
    int getManaCost();
    boolean canEquip(Character user);
}
