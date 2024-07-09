package com.dbc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {

    private ArrayList<String> players = new ArrayList<>();

    public Score(){};

    public void addPlauer(String name){
        players.add(name);
    }

    public void board(){
        // gerar dados de score
        // SELECT
        HashMap<String, Integer> countPlayers = new HashMap<>();
        
        for(String name : players){
            if(name != null){
                countPlayers.put(name, countPlayers.getOrDefault(name, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(countPlayers.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for(Map.Entry<String, Integer> entry : sortedEntries){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
