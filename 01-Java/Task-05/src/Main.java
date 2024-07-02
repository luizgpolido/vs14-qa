import entities.*;
import entities.Character;
import services.MenuService;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playerIntroMusic();

        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        ArrayList<Character> characterList = new ArrayList<>();

        characterList.add(new Java(10, 1, "Javoso"));
        characterList.add(new React(10, 1, "Reactero"));

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
                    CharacterSelection characterSelection = new CharacterSelection(characterList);
                    musicPlayer.stopMusic();
                    //retorna um nome da lista
                    String character1 = characterSelection.selectCharacter(false);
                    //pega um nome aleatório da lista
                    String character2 = characterSelection.selectCharacter(true, character1);
                    //retorna um Character
                    Character player1 = characterSelection.returnCharacter(character1);
                    Character player2 = characterSelection.returnCharacter(character2);
                    Battle battle = new Battle(player1, player2, score);
                    battle.battle();
                    musicPlayer.playerIntroMusic();
                    break;
                case 2:
                    System.out.println("Escolha sua stack preferida");
                    menuService.characterSelectionScreen();
                    Thread.sleep(4000);
                    break;
                case 3:
                    System.out.println("________________________________________________________________________________________________________________________\n");
                    System.out.println("                                                   VITÓRIAS                                                             ");
                    score.board();
                    System.out.println("\n________________________________________________________________________________________________________________________");
                    Thread.sleep(3000);
                    break;

                case 4:
                    System.out.println("Salvando... Não desligue o computador...");
                    Thread.sleep(3000);
                    return;
            }
        }
    }
}