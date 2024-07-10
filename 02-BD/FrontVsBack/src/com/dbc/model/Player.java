package com.dbc.model;

public class Player {

    private Integer idPlayer;
    private String name;

    public Player(Integer idPlayer, String name) {
        this.idPlayer = idPlayer;
        this.name = name;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
