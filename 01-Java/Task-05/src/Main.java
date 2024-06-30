import entities.Battle;
import entities.Java;
import entities.React;
import services.MenuService;
import entities.MusicPlayer;

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

        while (true) {
            System.out.println(menuService.getMainMenu());

            int opt = scanner.nextInt();
            scanner.nextLine();
            menuService.clear();

            switch (opt) {
                case 1:
<<<<<<< HEAD
                    System.out.println(menuService.getCharacterMenu());


                    switch (opt) { //ataques
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }















=======
                    // new player and npc
                    musicPlayer.stopMusic();
                    Java player1 = new Java(16, 2, "Javoso");
                    React player2 = new React(16, 2, "Reactero");
                    Battle battle = new Battle(player1, player2);
                    battle.battle();
                    musicPlayer.playerIntroMusic()
                    ;
>>>>>>> 661cb73f4f55326c9fb48e9b615b75d3182b24d9
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Salvando... Não desligue o computador...");
                    Thread.sleep(3000);
                    return;
            }
        }







    }
}
