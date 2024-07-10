package com.dbc.view;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.*;
import com.dbc.model.CharacterFight;
import com.dbc.repository.PlayerRepository;
import com.dbc.service.MenuService;
import com.dbc.service.PlayerService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            MusicPlayer musicPlayer = new MusicPlayer();

            Scanner scanner = new Scanner(System.in);
            MenuService menuService = new MenuService();
            ArrayList<CharacterFight> characterList = new ArrayList<>();

            characterList.add(new Java(12, 1, "Javoso"));
            characterList.add(new React(8, 2, "Reactero"));
            characterList.add(new Portugol(9, 1, "Portugolino"));

            System.out.println("Para uma melhor experiência, utilize o terminal em tela cheia.\n\n");
            Thread.sleep(2000);
            menuService.clear();

            System.out.println(menuService.getLogoDBC());
            Thread.sleep(2000);
            menuService.clear();
            Score score = new Score();
            musicPlayer.playerIntroMusic();


        
            while (true) {
                int opt = 0;
                try {
                    System.out.println(menuService.getMainMenu());
                    opt = scanner.nextInt();
                    scanner.nextLine();
                    menuService.clear();
                }
                catch (InputMismatchException exception){
                    System.out.println("Entrada incorreta! Digite apenas números!");
                    scanner.nextLine();
                    Thread.sleep(2000);

                }
                    switch (opt) {
                        case 1:
                            //add player to player table
                            System.out.println("qual é o nome do player? ");
                            String playerName = scanner.nextLine();

                            CharacterSelection characterSelection = new CharacterSelection(characterList);
                            musicPlayer.stopMusic();
                            String character1 = characterSelection.selectCharacter(false);
                            if (character1.equals("Erro")){
                                break;
                            }


                            PlayerService playerService = new PlayerService(new PlayerRepository());
                            playerService.insert(new Player(playerName));

                            String character2 = characterSelection.selectCharacter(true, character1);
                            CharacterFight player1 = characterSelection.returnCharacter(character1);
                            CharacterFight player2 = characterSelection.returnCharacter(character2);
                            Battle battle = new Battle(player1, player2);
                            battle.battle();
                            musicPlayer.playerIntroMusic();
                            break;
                        case 2:
                            System.out.println("Escolha sua stack preferida");
                            menuService.characterSelectionScreen();
                            Thread.sleep(4000);
                            break;
                        case 3:

                            try {
                                score.displayScore();
                            } catch (BancoDeDadosException e) {
                                throw new RuntimeException(e);
                            }
                            Thread.sleep(3000);
                            break;

                        case 4:
                            System.out.println("Salvando... Não desligue o computador...");
                            Thread.sleep(3000);
                            return;
                }

                }

            } catch (InterruptedException exception){
            System.out.println(exception.getMessage());
        }
        }


    }
