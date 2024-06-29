package entities;

import services.MenuService;

import java.util.Random;
import java.util.Scanner;

public class Battle {

    private  Character player1;
    private  Character player2;

    public Battle() {

    }

    public Battle(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Character getPlayer() {
        return player1;
    }



    public void battle() {

        MenuService menuService = new MenuService();

        while (player1.getHitPoints() > 0 && player2.getHitPoints() > 0) {

            System.out.println("""
                    Escolha seu ataque: 
                    1 - Ataque
                    2 - Ataque Pesado
                    3 - Ataque Especial
                    """);

            Scanner scanner = new Scanner(System.in);
            int opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) { //ataques
                case 1:
                    int damage = player1.lightAttack(player1.getStrenght());
                    player2.deduceHitPoints(damage);
                    break;
                case 2:
                    damage = player1.heavyAttack(player1.getStrenght());
                    player2.deduceHitPoints(damage);
                    break;
                case 3:
                    damage = player1.specialAttack(player1.getStrenght());
                    player2.deduceHitPoints(damage);
                    break;
            }

            // turno do npc
            Random random = new Random();
            opt = random.nextInt(3)+1;
            switch (opt) { //ataques
                case 1:
                    int damage = player2.lightAttack(player2.getStrenght());
                    player1.deduceHitPoints(damage);
                    break;
                case 2:
                    damage = player2.heavyAttack(player2.getStrenght());
                    player1.deduceHitPoints(damage);
                    break;
                case 3:
                    damage = player2.specialAttack(player2.getStrenght());
                    player1.deduceHitPoints(damage);
                    break;
            }

            menuService.battleScreen(player1, player2);

        }
    }
}
