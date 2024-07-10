package com.dbc.service;

import com.dbc.model.CharacterFight;

public class MenuService {


    public void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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

    public void battleScreen(CharacterFight player1, CharacterFight player2) {
        System.out.println("                                                                                                                              ");
        System.out.println("                                                                    "+player2.getPlayerHead()                                               );
        System.out.println("                                                                     /T\\                                                                   ");
        System.out.println("                                                                    / | \\                                                                 ");
        System.out.println("                                                                     / \\                                                                   ");
        System.out.println("                                                                    /   \\                                                                 ");
        System.out.println("                "+player1.getPlayerHead()+"                                              "+player2.getName()          );
        System.out.println("                 /T\\                                                "+printBar("❤", player2.getHitPoints())         );
        System.out.println("                / | \\▬ι═══ﺤ                                                                                             ");
        System.out.println("                  |                                                                                                       ");
        System.out.println("                 / \\                                                                                                     ");
        System.out.println("                /   \\                                                                                                    ");
        System.out.println("          "+player1.getName()                                                                                                  );
        System.out.println("          "+printBar("❤", player1.getHitPoints())                                                                             );
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("          [1] Ataque                                            [4] Fugir                                                  ");
        System.out.println("          [2] Ataque pesado                                                                                             ");
        System.out.println("          [3] Ataque especial                                                                                           ");
        System.out.println("                                                                                                                        ");

    }










    public String printBar(String string, int amount) {
        return string.repeat(amount);
    }

    public void characterSelectionScreen() {

        String select = """
                
                
                
                   (⌐■_■)
                     /T\\                       (ಠ益ಠ)                   (ô_Ô) ?
                    / | \\▬ι═══ﺤ                /T\\                       /T\\ 
                      |                       / | \\                     / | \\
                     / \\                       / \\                       / \\ 
                    /   \\                     /   \\                     /   \\
                +-----------+            +-------------+            +----------------+                       \s
                | [1]Javoso |            | [2]Reactero |            | [3]Portugolino |  \s
                +-----------+            +-------------+            +----------------+
                
                
                
                """;
        System.out.println(select);
    }

    public void impactFrameHit() {
        System.out.println("""
                
                
                                                 HIT!
                                                            !
                                       !                            !
                                           (o_o)            (*O*)            
                                           /|_|\\🔪          /|_|\\           ! 
                             !              L L              | |                                                                                           
                                    !
                                                        !
                
                
                
                """);
    }

    public void impactFrameDodge() {
        System.out.println("""
                
                
                                                 DODGE!
                                                            
                                                                   
                                           (╥﹏╥)            ε=ε=┏( ・＿・)┛            
                                           /|_|\\🔪                     
                                            L L                                                                                                        
                                    
                                                        
                
                
                """);
    }
}