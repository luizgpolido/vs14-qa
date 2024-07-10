package com.dbc.model;

import java.time.LocalDate;

public class ScoreModel {
    private Integer victories;
    private LocalDate date;
    private String winner_name;


    public Integer getVictories() {
        return victories;
    }

    public void setVictories(Integer victories) {
        this.victories = victories;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWinner_name() {
        return winner_name;
    }

    public void setWinner_name(String winner_name) {
        this.winner_name = winner_name;
    }


    @Override
    public String toString() {
        return "ScoreModel{" +
                "victories=" + victories +
                ", date=" + date +
                ", winner_name='" + winner_name + '\'' +
                '}';
    }
}