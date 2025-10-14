import java.util.*;

public class Main {
    public static void main(String[] args) {
        Warrior w = new Warrior("Guerreiro");
    }
}

//#region trash
//     /* ----------------------
//        Interfaces e modelos
//        ---------------------- */
//     // Resultado de um ataque (dano total aplicado e efeitos aplicados)
//     static class AttackResult {
//         int totalDamageDealt;
//         List<StatusEffect> appliedEffects = new ArrayList<>();
//         String description = "";
//     }

//     // Efeitos de status (por turno)
//     abstract static class StatusEffect {
//         String name;
//         int remainingTurns;
//         Character source;

//         StatusEffect(String name, int duration, Character source) {
//             this.name = name;
//             this.remainingTurns = duration;
//             this.source = source;
//         }

//         // aplica quando o efeito "ticka" no início do turno do alvo
//         abstract void onTick(Character target);

//         // chamado quando efeito é aplicado (opcional)
//         void onApply(Character target) {}

//         // chamado quando efeito termina (opcional)
//         void onExpire(Character target) {}

//         boolean isExpired() {
//             return remainingTurns <= 0;
//         }

//         void reduceDuration() {
//             remainingTurns--;
//         }

//         @Override
//         public String toString() {
//             return name + " (" + remainingTurns + "t)";
//         }
//     }

//     /* ----------------------
//        StatusEffects implementados
//        ---------------------- */

//     // Sangramento: dano adicional por turno
//     static class BleedEffect extends StatusEffect {
//         int damagePerTurn;
//         BleedEffect(int dmg, int turns, Character source) {
//             super("Sangramento", turns, source);
//             this.damagePerTurn = dmg;
//         }

//         @Override
//         void onTick(Character target) {
//             if (!target.isAlive()) return;
//             target.hp -= damagePerTurn;
//             if (target.hp < 0) target.hp = 0;
//             System.out.println(target.name + " sofre " + damagePerTurn + " de Sangramento. (HP:" + target.hp + "/" + target.maxHp + ")");
//         }
//     }

//     // Queimadura
//     static class BurnEffect extends StatusEffect {
//         int damagePerTurn;
//         BurnEffect(int dmg, int turns, Character source) {
//             super("Queimadura", turns, source);
//             this.damagePerTurn = dmg;
//         }

//         @Override
//         void onTick(Character target) {
//             if (!target.isAlive()) return;
//             target.hp -= damagePerTurn;
//             if (target.hp < 0) target.hp = 0;
//             System.out.println(target.name + " sofre " + damagePerTurn + " de Queimadura. (HP:" + target.hp + "/" + target.maxHp + ")");
//         }
//     }

//     // Atordoado: perde turno (representado por flag aqui)
//     static class StunEffect extends StatusEffect {
//         StunEffect(int turns, Character source) {
//             super("Atordoado", turns, source);
//         }

//         @Override
//         void onTick(Character target) {
//             // simples: não faz dano, mas jogo checará isStunned
//             System.out.println(target.name + " está atordoado e não age este turno!");
//         }
//     }

//     // Helper: condição de requisito
//     static boolean reqStrength(Character c, int min) { return c.strength >= min; }
//     static boolean reqDex(Character c, int min) { return c.dexterity >= min; }
//     static boolean reqInt(Character c, int min) { return c.intelligence >= min; }

//     /* ----------------------
//        Sistema de batalha
//        ---------------------- */

//     static class Battle {
//         List<Character> allies;
//         List<Character> enemies;
//         int turn = 1;

//         Battle(List<Character> allies, List<Character> enemies) {
//             this.allies = allies;
//             this.enemies = enemies;
//         }

//         boolean allDead(List<Character> list) {
//             return list.stream().noneMatch(Character::isAlive);
//         }

//         // get living list
//         List<Character> living(List<Character> list) {
//             List<Character> res = new ArrayList<>();
//             for (Character c : list) if (c.isAlive()) res.add(c);
//             return res;
//         }

//         void run() {
//             System.out.println("=== BATALHA INICIA ===");
//             while (true) {
//                 System.out.println("\n--- Turno " + turn + " ---");
//                 // ordem simples: aliados primeiro, depois inimigos; em implementações reais, ordenar por destreza
//                 // START TURNS
//                 for (Character c : concat(allies, enemies)) {
//                     if (!c.isAlive()) continue;
//                     c.startTurn();
//                 }

//                 // Ações: Allies
//                 for (Character a : allies) {
//                     if (!a.isAlive()) continue;
//                     // escolhe alvo inimigo vivo
//                     List<Character> livingEnemies = living(enemies);
//                     if (livingEnemies.isEmpty()) break;
//                     // checar se está atordoado (has StunEffect with remainingTurns > 0) -> skip
//                     boolean isStunned = a.effects.stream().anyMatch(e -> e instanceof StunEffect && e.remainingTurns > 0);
//                     if (isStunned) {
//                         System.out.println(a.name + " está atordoado e perde este turno.");
//                         continue;
//                     }
//                     // Demostrar troca de arma: opcional exemplo - se mana >= X, equipar arma mágica
//                     autoEquipStrategy(a);

//                     // alvo selection: se arma área (ElvenBow), enviar todos inimigos; caso contrário, 1 alvo aleatório
//                     List<Character> targets = new ArrayList<>();
//                     if (a.equipped instanceof ElvenBow) {
//                         targets.addAll(livingEnemies);
//                     } else {
//                         // prioridade: inimigo com menor HP
//                         livingEnemies.sort(Comparator.comparingInt(c -> c.hp));
//                         targets.add(livingEnemies.get(0));
//                     }

//                     System.out.println("\nAção de " + a.name + ": " + a.stats());
//                     AttackResult res = a.attack(targets);
//                     System.out.println(res.description);
//                     // checar vitória
//                     if (allDead(enemies)) {
//                         System.out.println("=== VITÓRIA! Inimigos derrotados. ===");
//                         return;
//                     }
//                 }

//                 // Inimigos agem
//                 for (Character e : enemies) {
//                     if (!e.isAlive()) continue;
//                     List<Character> livingAllies = living(allies);
//                     if (livingAllies.isEmpty()) break;
//                     boolean isStunned = e.effects.stream().anyMatch(s -> s instanceof StunEffect && s.remainingTurns > 0);
//                     if (isStunned) {
//                         System.out.println(e.name + " está atordoado e perde este turno.");
//                         continue;
//                     }
//                     // inimigo ataca alvo aleatório
//                     Character target = livingAllies.get(new Random().nextInt(livingAllies.size()));
//                     // se inimigo equipou arma, usa; senão ataca com soco
//                     List<Character> targs = Collections.singletonList(target);
//                     System.out.println("\nAção de " + e.name + ": " + e.stats());
//                     AttackResult res = e.attack(targs);
//                     System.out.println(res.description);
//                     if (allDead(allies)) {
//                         System.out.println("=== DERROTA! Todos os aliados foram derrotados. ===");
//                         return;
//                     }
//                 }

//                 // END TURNS
//                 for (Character c : concat(allies, enemies)) {
//                     if (!c.isAlive()) continue;
//                     c.endTurn();
//                 }

//                 turn++;
//                 if (turn > 100) {
//                     System.out.println("Batalha terminou por limite de turnos.");
//                     return;
//                 }
//             }
//         }

//         // estratégia de troca automática para demo: equipar a melhor arma que pode usar disponível
//         void autoEquipStrategy(Character c) {
//             // exemplo de troca: se for mago e tiver mana, equipar cajado; se arqueiro com mana equipar arco; warrior preferir machado ou espada.
//             if (c instanceof Mage) {
//                 Weapon staff = new ArcaneStaff();
//                 c.equip(staff);
//             } else if (c instanceof Archer) {
//                 // se tiver mana suficiente, equipar arco; senão adaga
//                 Weapon bow = new ElvenBow();
//                 Weapon dagger = new ShadowDagger();
//                 if (c.mp >= bow.getManaCost() && bow.canEquip(c)) c.equip(bow);
//                 else if (dagger.canEquip(c)) c.equip(dagger);
//             } else if (c instanceof Warrior) {
//                 Weapon axe = new WarAxe();
//                 Weapon sword = new LongSword();
//                 if (axe.canEquip(c)) c.equip(axe);
//                 else if (sword.canEquip(c)) c.equip(sword);
//             } else if (c instanceof Paladin) {
//                 // paladin prefer martelo sagrado
//                 Weapon hammer = new HolyHammer();
//                 if (hammer.canEquip(c)) c.equip(hammer);
//             } else {
//                 // default: try shadow dagger or longsword
//                 Weapon dagger = new ShadowDagger();
//                 Weapon sword = new LongSword();
//                 if (dagger.canEquip(c)) c.equip(dagger);
//                 else if (sword.canEquip(c)) c.equip(sword);
//             }
//         }

//         // helper to concat
//         List<Character> concat(List<Character> a, List<Character> b) {
//             List<Character> res = new ArrayList<>();
//             res.addAll(a);
//             res.addAll(b);
//             return res;
//         }
//     }

//     /* ----------------------
//        Demo main
//        ---------------------- */

//     public static void main(String[] args) {
//         // Cria personagens
//         Warrior w = new Warrior("Guerreiro-1");
//         Archer ar = new Archer("Arqueiro-1");
//         Mage m = new Mage("Mago-1");
//         Paladin p = new Paladin("Paladino-1");

//         // equipamentos iniciais (poderiam ser trocados durante a batalha)
//         // Demonstração:
//         w.equip(new LongSword());
//         ar.equip(new ElvenBow());
//         m.equip(new ArcaneStaff());
//         p.equip(new HolyHammer());

//         // inimigos
//         Enemy gob1 = new Enemy("Goblin A", 40, 10, 7, 8, 3);
//         Enemy gob2 = new Enemy("Goblin B", 45, 5, 6, 6, 2);
//         Enemy ogre = new Enemy("Ogro", 100, 0, 18, 4, 1);
//         // equipar arma simples ao ogre para variação
//         ogre.equip(new WarAxe());

//         List<Character> allies = new ArrayList<>(Arrays.asList(w, ar, m, p));
//         List<Character> enemies = new ArrayList<>(Arrays.asList(gob1, gob2, ogre));

//         Battle battle = new Battle(allies, enemies);
//         battle.run();

//         System.out.println("\n=== FIM DA DEMONSTRAÇÃO ===");
//     }
// }
//#endregion