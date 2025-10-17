import StatusEffect.StatusEffect;

public class SpecialAttack {
    int damage;
    boolean isAoE;
    StatusEffect statusEffect;
    int statusEffectChance;

    public SpecialAttack(int damage, boolean isAoE, StatusEffect statusEffect, int statusEffectChance) {
        this.damage = damage;
        this.isAoE = isAoE;
        this.statusEffect = statusEffect;
        this.statusEffectChance = statusEffectChance;
    }
}
