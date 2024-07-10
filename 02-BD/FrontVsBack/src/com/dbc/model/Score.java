package com.dbc.model;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.ConexaoBancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Score {

    // ====================================deletar?vv
    private ArrayList<String> players = new ArrayList<>();

    public Score(){};

    public void addPlauer(String name){
        players.add(name);
    }
    // ====================================deletar?^^

    public void displayScore() throws BancoDeDadosException {
        List<ScoreModel> winners = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            // retorna table:    | victories(number) | winner_name(varchar) | battle_date |
            String sql = """
                    ALTER SESSION SET CURRENT_SCHEMA=FRONT_VS_BACK;
                    
                    SELECT * FROM (
                         SELECT COUNT(gc.NAME) winner, gc.NAME AS victories FROM BATTLE b\s
                         JOIN GAME_CHARACTER gc ON (gc.ID_GAME_CHARACTER = b.ID_WINNER)
                         GROUP BY gc.NAME\s
                         
                         UNION
                         
                         SELECT COUNT(p.NAME), p.NAME AS victories FROM BATTLE b\s
                         JOIN PLAYER p ON (p.id_player = b.ID_WINNER)
                         GROUP BY p.NAME
                         )
                         ORDER BY victories DESC;
                    """;

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                ScoreModel winner = new ScoreModel();
                winner.setVictories(res.getInt("victories"));
                winner.setWinner_name(res.getString("winner_name"));
                winners.add(winner);
            }

            System.out.println("________________________________________________________________________________________________________________________\n");
            System.out.println("                                                   VITÓRIAS                                                             ");
            for (ScoreModel winner : winners) {
            System.out.println("                                   | "+winner.getWinner_name()+" | "+winner.getVictories()+" | ");
            }
            System.out.println("\n________________________________________________________________________________________________________________________");


        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
