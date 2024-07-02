package entities;

import services.MenuService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class CharacterSelection {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Character> characterList;

    public CharacterSelection(ArrayList<Character> characterList) {
        this.characterList = characterList;
    }

    public void addCharacter(Character character) {
        characterList.add(character);
    }

    public String selectCharacter(boolean randomCharacter) {

        if (randomCharacter) {
            Random random = new Random();
            String characterName = characterList.get(random.nextInt(characterList.size())).getName();
            return characterName;
        } else {
            MenuService menuService = new MenuService();
            menuService.characterSelectionScreen();
            int opt = scanner.nextInt()-1;
            String characterName = characterList.get(opt).getName();
            return characterName;
        }
    }

    public Character returnCharacter(String characterName) {
        for (Character character : characterList) {
            if (character.getName().equals(characterName)) {
                return character;
            }
        }
        return null;
    }





}