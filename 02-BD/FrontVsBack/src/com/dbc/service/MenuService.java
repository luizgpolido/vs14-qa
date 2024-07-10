package com.dbc.service;

import com.dbc.model.CharacterFight;

public class MenuService {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";






    public void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


    public String getLogoDBC() {
        String logo = String.format(
                """
                                   %1$s
                                
                                  %2$s ██████╗ ██████╗  ██████╗
                                   ██╔══██╗██╔══██╗██╔════╝
                                   ██║  ██║██████╔╝██║    \s
                                   ██║  ██║██╔══██╗██║    \s
                                   ██████╔╝██████╔╝╚██████╗
                                   ╚═════╝ ╚═════╝  ╚═════╝ %1$s
                                                          \s
                                   
                           
                                                  
                                                  
                """, ANSI_RESET, ANSI_BLUE
        );
        return logo;
    }

    public String getMainMenu() {
        String menu = String.format(
                """
                        %1$s
                      
                           %2$s____                   __\s%1$s
                          %2$s/ __/  ____ ___   ___  / /_%1$s
                         %2$s/ _/   / __// _ \\ / _ \\/ __/%1$s
                        %2$s/_/    /_/   \\___//_//_/\\__/\s%1$s
                                                    %3$s _  __  ___%1$s
                                                    %3$s| |/ / (_-<%1$s
                                                    %3$s|___/ /___/%1$s
                                                              %4$s___               __ \s%1$s
                                                              %4$s/ _ ) ___ _ ____  / /__%1$s
                                                             %4$s/ _  |/ _ `// __/ /  '_/%1$s
                                                            %4$s/____/ \\_,_/ \\__/ /_/\\_\\\s%1$s
                                                        
                    
________________________________________________________________________________________________________________________
                    Jogar[%5$s1%1$s]          Personagens[%5$s2%1$s]          Classificação[%5$s3%1$s]          %4$sSair%1$s[%5$s4%1$s]
                            """, ANSI_RESET, ANSI_CYAN, ANSI_WHITE, ANSI_RED, ANSI_MAGENTA
        );
        return menu;
    }

    public void battleScreen(CharacterFight player1, CharacterFight player2) {
        System.out.println("                                                                                                                                           ");
        System.out.println("                                                                    "+player2.getPlayerHead()                                               );
        System.out.println("                                                                     /T\\                                                                  ");
        System.out.println("                                                                    / | \\                                                                 ");
        System.out.println("                                                                     / \\                                                                  ");
        System.out.println("                                                                    /   \\                                                                 ");
        System.out.println("                "+player1.getPlayerHead()+"                                              "+player2.getName()                                );
        System.out.println("                 /T\\                                                "+printBar(ANSI_RED+"❤"+ANSI_RESET, player2.getHitPoints())     );
        System.out.println("                / | \\"+ANSI_BLACK+"▬ι"+ANSI_RESET+"═══ﺤ");
        System.out.println("                  |                                                                                                                        ");
        System.out.println("                 / \\                                                                                                                      ");
        System.out.println("                /   \\                                                                                                                     ");
        System.out.println("          "+player1.getName()                                                                                                               );
        System.out.println("          "+printBar(ANSI_RED+"❤"+ANSI_RESET, player1.getHitPoints())                                                                );
        System.out.println("________________________________________________________________________________________________________________________                   ");
        System.out.println("          ["+ANSI_MAGENTA+"1"+ANSI_RESET+"] "+ANSI_GREEN+"Ataque"+ANSI_RESET+"                                            ["+ANSI_MAGENTA+"4"+ANSI_RESET+"] "+ANSI_BLACK+"Fugir"+ANSI_RESET);
        System.out.println("          ["+ANSI_MAGENTA+"2"+ANSI_RESET+"] "+ANSI_YELLOW+"Ataque pesado"+ANSI_RESET+"                                                                                  ");
        System.out.println("          ["+ANSI_MAGENTA+"3"+ANSI_RESET+"] "+ANSI_RED+"Ataque especial"+ANSI_RESET+"                                                                                ");
        System.out.println("                                                                                                                                           ");

    }


    public String printBar(String string, int amount) {
        return string.repeat(amount);
    }

    public void characterSelectionScreen() {

        String select = String.format(
                """
                   %1$s
                
                
                   (%3$s⌐■_■%1$s)
                     /T\\                       (%4$sಠ益ಠ%1$s)                   (%5$sô%1$s_%2$sÔ%1$s) %6$s?%1$s
                    / | \\%3$s▬ι%1$s═══ﺤ                /T\\                       /T\\ 
                      |                       / | \\                     / | \\
                     / \\                       / \\                       / \\ 
                    /   \\                     /   \\                     /   \\
                +-----------+            +-------------+            +----------------+                       \s
                | [%2$s1%1$s]Javoso|            | [%2$s2%1$s]Reactero |            | [%2$s3%1$s]Portugolino |  \s
                +-----------+            +-------------+            +----------------+
                
                
                
                """, ANSI_RESET, ANSI_MAGENTA, ANSI_BLACK, ANSI_RED, ANSI_BLUE, ANSI_YELLOW
        );
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