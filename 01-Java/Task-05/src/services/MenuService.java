package services;

import entities.Character;

public class MenuService {


    public void clear() {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
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
        System.out.println("                                                                                            \uD83D\uDE08                 ");
        System.out.println("                                                                                            /T\\                      ");
        System.out.println("                                                                                           / | \\                         ");
        System.out.println("                    (⌐■_■)                                                                  / \\                           ");
        System.out.println("                     /T\\                                                                   /   \\                          ");
        System.out.println("                    / | \\▬ι═══ﺤ                                                           "+player2.getName()             );
        System.out.println("                      |                                                                     "+printBar("❤", player2.getHitPoints()) );
        System.out.println("                     / \\                                                                                                  ");
        System.out.println("                    /   \\                                                                                                  ");
        System.out.println("          "+player1.getName()                                                                                            );
        System.out.println("          "+printBar("❤", player1.getHitPoints())                                                                     );
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("          [1] Ataque                                                 [4] Loja                                           ");
        System.out.println("          [2] Ataque pesado                                          [5] Fugir                                          ");
        System.out.println("          [3] Ataque especial                                                                                           ");
        System.out.println("                                                                                                                        ");

    }




    public String printBar(String string, int amount) {
        return string.repeat(amount);
    }

    public void characterSelectionScreen() {
        String select = """
                Selecione seu personagem:
                
        +-----------+    +-------------+
        | [1]Javoso |    | [2]Reactero |    
        +-----------+    +-------------+                
                
                
                
                
                
                
                
                
                
                
                
                
                """;
        System.out.println(select);
    }



}
