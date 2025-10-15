public abstract class Character {
    String name;
    int maxHp;
    int hp;
    int maxMp;
    int mp;
    int strength;
    int dexterity;
    int intelligence;
    Weapon equippedWeapon;

    Character(String name, int hp, int mp, int str, int dex, int intl) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.maxMp = mp;
        this.mp = mp;
        this.strength = str;
        this.dexterity = dex;
        this.intelligence = intl;
    }

    public boolean equipWeapon(Weapon weapon) {
        if (!weapon.canEquip(this)) {
            return false;
        }
        this.equippedWeapon = weapon;
        return true;
    }
}
