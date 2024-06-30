package services;

import entities.Character;

public class MenuService {


    public void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n" +
                "\n\n");
    }


    public String getLogoDBC() {
        String logo = """
                                   
                                   
                                   ██████╗ ██████╗  ██████╗
                                   ██╔══██╗██╔══██╗██╔════╝
                                   ██║  ██║██████╔╝██║    \s
                                   ██║  ██║██╔══██╗██║    \s
                                   ██████╔╝██████╔╝╚██████╗
                                   ╚═════╝ ╚═════╝  ╚═════╝
                                                          \s
                                   
                           
                                                  
                                                  
                """;
        return logo;
    }

    public String getMainMenu() {
        String menu = """

                        
                           ____                   __\s
                          / __/  ____ ___   ___  / /_
                         / _/   / __// _ \\ / _ \\/ __/
                        /_/    /_/   \\___//_//_/\\__/\s
                                                     _  __  ___
                                                    | |/ / (_-<
                                                    |___/ /___/
                                                              ___               __ \s
                                                              / _ ) ___ _ ____  / /__
                                                             / _  |/ _ `// __/ /  '_/
                                                            /____/ \\_,_/ \\__/ /_/\\_\\\s
                                                        
                    
________________________________________________________________________________________________________________________
                    Jogar[1]          Personagens[2]          Classificação[3]          Sair[4]
                            """;
        return menu;
    }

   //mostrar nome dos players
   // mostrar vida
   // mostrar dano sofrido
    public void battleScreen(Character player1, Character player2) {
        System.out.println("                                                                                                                        ");
        System.out.println("                                                                                            \uD83D\uDE08                     ");
        System.out.println("                                                                                            /T\\                      ");
        System.out.println("                                                                                           / | \\                         ");
        System.out.println("                    (⌐■_■)                                                                  / \\                            ");
        System.out.println("                     /T\\                                                                  /   \\                          ");
        System.out.println("                 🛡 / | \\▬▬ι════════ﺤ                                                     "+player2.getName()             );
        System.out.println("                      |                                                                    ❤: "+player2.getHitPoints() );
        System.out.println("                     / \\                                                                                                  ");
        System.out.println("                    /   \\                                                                                                  ");
        System.out.println("          "+player1.getName()                                                                                            );
        System.out.println("           ❤: "+player1.getHitPoints()                                                                                );
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("          [1] Ataque                                                                                                    ");
        System.out.println("          [2] Ataque pesado                                                                                             ");
        System.out.println("          [3] Ataque especial                                                                                           ");
//
//                                                                                        player 2  %
//                          
//                               player 1   %                                              
//                              
//                                            \s
//                        @                   \s
//                       @@                   \s
//                    @@@@                    \s
//                 @@@@@@   @@@@              \s                                                                \s
//              @@@@@@  @@@@@                 \s                                 (((,       /(((                \s
//             @@@@@   @@@/                   \s                                (     (( ((     (               \s
//             @@@    @@@@@                   \s                               .(     (( ((     (               \s
//              @@@    @@@@@                  \s                                (((((((((((((((((               \s
//                @@     @@@/                 \s                           ((.   ( (   (((  ,( (   ,((          \s
//                  (,   @@                   \s                          (      .(   (((((   (       (         \s
//    .@@@@@@             (@@@@@     @@@      \s                           *((  .( (*   /   /( (   ((.          \s
//        &@@@@@@@@@@@@&             @@@      \s                                (((((((((((((((((               \s
//        @@@@@          @@@@       @@@       \s                                (     *( (.     (               \s
//           #@@@@@@@@@@@@#      @@           \s                                (     (( ((     (               \s
//          @@@@@@  @@@@@@@@@                 \s                                 *(/         /(,                \s
// ,@@@@@     (@@@@@@@@@@(           @        \s
// @@@@@@                        @@@@@        \s
//     *@@@@@@@@@@@@@@@@@@@@@@@@%      #@@    \s
//        @@                    ,@@@@@%       \s
//                                                                                    vida do player 2
//                               ataque executado
//
    }
}
