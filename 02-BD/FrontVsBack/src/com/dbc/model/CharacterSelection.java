package com.dbc.model;

import com.dbc.service.MenuService;

import java.util.*;

public class CharacterSelection {
    Scanner scanner = new Scanner(System.in);
    ArrayList<CharacterFight> characterList;

    public CharacterSelection(ArrayList<CharacterFight> characterList) {
        this.characterList = characterList;
    }

    public void addCharacter(CharacterFight character) {
        characterList.add(character);
    }

    public String selectCharacter(boolean randomCharacter) throws InterruptedException {
        int opt = 0;
        while (true){
            if (randomCharacter) {
                Random random = new Random();
                String characterName = characterList.get(random.nextInt(characterList.size())).getName();
                return characterName;
            } else {
                MenuService menuService = new MenuService();
                menuService.characterSelectionScreen();
                try {
                    opt = scanner.nextInt()-1;
                } catch (InputMismatchException exception){
                    System.out.println("Entrada incorreta! Digite apenas números!");
                    scanner.nextLine();
                    Thread.sleep(2000);
                    break;
                }
                String characterName = characterList.get(opt).getName();
                return characterName;
            }
        }
        return "Erro";
    }

    // Overloaded method
    public String selectCharacter(boolean randomCharacter, String notInclude) throws InterruptedException {
        while (true){
            if (randomCharacter) {
                ArrayList<CharacterFight> lesserCharacterList = new ArrayList<>();
                for (CharacterFight character : characterList) {
                    if (!character.getName().equals(notInclude))
                        lesserCharacterList.add(character);
                }
                Random random = new Random();
                String characterName = lesserCharacterList.get(random.nextInt(lesserCharacterList.size())).getName();
                return characterName;
            } else {
                MenuService menuService = new MenuService();
                menuService.characterSelectionScreen();
                int opt = 0;
                try {
                    opt = scanner.nextInt()-1;
                } catch (InputMismatchException exception){
                    System.out.println("Entrada incorreta! Digite apenas números!");
                    scanner.nextLine();
                    Thread.sleep(2000);
                }

                String characterName = characterList.get(opt).getName();
                return characterName;
            }
        }
    }

    public CharacterFight returnCharacter(String characterName) {
        for (CharacterFight character : characterList) {
            if (character.getName().equals(characterName)) {
                return character;
            }
        }
        return null;
    }

}