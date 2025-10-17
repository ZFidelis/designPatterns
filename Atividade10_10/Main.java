import java.util.*;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Battle at = new Battle();
        List<Character> targets = new ArrayList<>();

        
        // inimigos/targets presetados
        Character e1 = new Enemy("Goblin 1", 50, 10, 17, 5, 1);
        Character e2 = new Enemy("Goblin 2", 70, 10, 15, 5, 1);
        targets.add(e1);
        targets.add(e2);

        Character personagem;

        System.out.print("Quantos turnos deseja: ");
        int rounds = scan.nextInt();
        System.out.println("\n1. Guerreiro \n2. Mago \n3. Arqueiro");
        System.out.print("Qual personagem deseja usar: ");
        int charChoice = scan.nextInt();

        switch(charChoice) {
            case 1:
                personagem = new Warrior("Guereiro");
                break;
            case 2:
                personagem = new Mage("Mago");
                break;
            case 3:
                personagem = new Archer("Arqueiro");
                break;
            default:
                personagem = new Paladin("Paladino");
        }

        for(int i = 1; i <= rounds; i++) {
            System.out.println("Turno " + i);
            
            System.out.println("\n\n--> Ações Disponíveis <--\n");
            System.out.println("1. Equipar Arma");
            System.out.println("2. Ataque Simples");
            System.out.println("3. Ataque Especial");
            System.out.println("4. Fugir");
            System.out.print("Escolha: ");
            int actChoice = scan.nextInt();

            switch(actChoice) {
                case 1:
                    while(true) {
                        Weapon selectedWeapon = weaponMenu();
                        if (selectedWeapon != null) {
                            if (personagem.equipWeapon(selectedWeapon)) {
                                System.out.println("A arma " + selectedWeapon.getName() + " foi equipada!");
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Atacar!");
                    at.attack(personagem, targets);
                    break;
                case 3:
                    at.specialAttack(personagem, targets);
                    break;
                default:
                    System.out.println("Você fugiu com sucesso!");
                    break;
            }

            if (actChoice != 1 && actChoice != 2 && actChoice != 3) {
                break;
            }
        
            if (rounds != 1) {
                at.enemyAttack(e2, personagem);
                at.enemyAttack(e1, personagem);
            }
        }
    }

    public static Weapon weaponMenu() {
        System.out.println("\n\n--> Escolha a arma para equipar <--\n");
        System.out.println("1. Arco Élfico");
        System.out.println("2. Cajado Arcano");
        System.out.println("3. Martelo Sagrado");
        System.out.println("4. Espada Longa");
        System.out.println("5. Adaga Sombria");
        System.out.println("6. Machado de Guerra");
        System.out.print("Escolha: ");
        int wpChoice = scan.nextInt();


        switch(wpChoice) {
            case 1:
                return new ElvenBow();
            case 2:
                return new ArcaneStaff();
            case 3:
                return new HolyHammer();
            case 4:
                return new LongSword();
            case 5:
                return new ShadowDagger();
            case 6:
                return new WarAxe();
            default:
                return null;
        }
    }
}