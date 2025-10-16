package StatusEffect;

public abstract class StatusEffect {
    int duration;
    int damage;
    boolean stun;

    public StatusEffect(int duration, int damage, boolean stun) {
        this.duration = duration;
        this.damage = damage;
        this.stun = stun;
    }
    
}
