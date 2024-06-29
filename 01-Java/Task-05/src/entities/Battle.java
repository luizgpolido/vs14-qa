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



    public void battle() throws InterruptedException {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playerBattleMusic();
        MenuService menuService = new MenuService();


        while (player1.getHitPoints() > 0 && player2.getHitPoints() > 0) {

            menuService.battleScreen(player1, player2);

            Scanner scanner = new Scanner(System.in);
            int opt = scanner.nextInt();
            scanner.nextLine();
            int damage = 0;
            switch (opt) { //ataques
                case 1:
                    damage = player1.lightAttack(player1.getStrenght());
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

            System.out.println(player1.getName() + " causou " + damage + " de dano a " + player2.getName());
            System.out.println(player2.getName() + " agora tem " + player2.getHitPoints() + " pontos de vida.\n");


            // turno do npc
            Random random = new Random();
            opt = random.nextInt(3)+1;
            switch (opt) { //ataques
                case 1:
                    damage = player2.lightAttack(player2.getStrenght());
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
            System.out.println(player2.getName() + " causou " + damage + " de dano a " + player1.getName());
            System.out.println(player1.getName() + " agora tem " + player1.getHitPoints() + " pontos de vida.\n");

        }
        musicPlayer.stopMusic();

        System.out.println("-----------------------------------------------------------------------");
        if (player1.getHitPoints() <= 0) {
            System.out.println("*************** " + player2.getName() + " venceu o combate!"+ " ***************");
            musicPlayer.playerGameOverMusic();
            Thread.sleep (8000);
            System.out.println("-----------------------------------------------------------------------");
        } else {

            System.out.println("*************** " + player1.getName() + " venceu o combate!" + " ***************");
            musicPlayer.playerWinMusic();
            Thread.sleep (8000);
            System.out.println("-----------------------------------------------------------------------");
        }
        musicPlayer.stopMusic();



    }
}
