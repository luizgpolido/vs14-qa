package services;

import entities.Character;

public class MenuService {





    public String getLogoDBC() {
        String logo = """
                 _______  .______     ______\s
                |       \\ |   _  \\   /      |
                |  .--.  ||  |_)  | |  ,----'
                |  |  |  ||   _  <  |  |    \s
                |  '--'  ||  |_)  | |  `----.
                |_______/ |______/   \\______|
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

    public String battleScreen(Character player1, Character player2) {
        //                      vida do player 2
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



        return String.format("  P1: "+player1.getHitPoints() + "P2: "+ player2.getHitPoints());
    }


}
