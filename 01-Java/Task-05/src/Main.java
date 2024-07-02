import entities.*;
import services.MenuService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playerIntroMusic();

        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();

        System.out.println("Para uma melhor experiência, utilize o terminal em tela cheia.\n\nPressione enter para continuar.");
        String wait = scanner.nextLine();
        menuService.clear();

        System.out.println(menuService.getLogoDBC());
        Thread.sleep(2000);
        menuService.clear();
        Score score = new Score();

        while (true) {
            System.out.println(menuService.getMainMenu());

            int opt = scanner.nextInt();
            scanner.nextLine();
            menuService.clear();

            switch (opt) {
                case 1:
                    // new player and npc
                    musicPlayer.stopMusic();
                    Java player1 = new Java(16, 2, "Javoso");
                    React player2 = new React(16, 2, "Reactero");
                    Battle battle = new Battle(player1, player2, score);
                    battle.battle();
                    musicPlayer.playerIntroMusic()
                    ;
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("________________________________________________________________________________________________________________________\n");
                    System.out.println("                                                   VITÓRIAS                                                             ");
                    score.board();
                    System.out.println("\n________________________________________________________________________________________________________________________");
                    Thread.sleep(3000);
                case 4:
                    System.out.println("Salvando... Não desligue o computador...");
                    Thread.sleep(3000);
                    return;
            }
        }
    }
}