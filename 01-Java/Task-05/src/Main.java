import services.MenuService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();

        System.out.println("Para uma melhor experiência, utilize o terminal em tela cheia.\n\nPressione qualquer tecla para continuar.");
        String wait = scanner.nextLine();

        System.out.println(menuService.getLogoDBC());
        Thread.sleep(1500);


        while (true) {
            System.out.println(menuService.getMainMenu());

            int opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    System.out.println(menuService.getCharacterMenu());


                    switch (opt) { //ataques
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }















                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Salvando... Não desligue o computador...");
                    Thread.sleep(3000);
                    return;
            }
        }







    }
}
