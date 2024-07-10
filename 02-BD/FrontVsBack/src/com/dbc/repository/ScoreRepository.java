package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Score;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScoreRepository implements Repository<Integer, Score> {


    public ScoreRepository() {}

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return 0;
    }

    @Override
    public Score adicionar(Score object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Score object) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Score> listar() throws BancoDeDadosException {
        List<Score> winners = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            // retorna table:    | victories(number) | winner_name(varchar) | battle_date |
            String sql = """
                    SELECT * FROM (
                    SELECT COUNT(gc.NAME) AS victories, gc.NAME AS winner, gc.id_game_character AS id_winner FROM BATTLE b
                    JOIN GAME_CHARACTER gc ON (gc.ID_GAME_CHARACTER = b.ID_WINNER)
                    GROUP BY gc.NAME ,gc.id_game_character
                    
                    UNION
                    
                    SELECT COUNT(p.NAME), p.NAME , p.id_player FROM BATTLE b
                    JOIN PLAYER p ON (p.id_player = b.ID_WINNER)\s
                    GROUP BY p.NAME, p.ID_PLAYER
                    )
                    ORDER BY victories DESC
                    """;

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Score winner = new Score();
                winner.setVictories(res.getInt("victories"));
                winner.setWinner_name(res.getString("winner"));
                winners.add(winner);
            }

            System.out.println("________________________________________________________________________________________________________________________\n");
            System.out.println("                                                   VITÓRIAS                                                             ");
            for (Score winner : winners) {
                System.out.println("                                              | "+winner.getWinner_name()+" | "+winner.getVictories()+" | ");
            }
            System.out.println("\n________________________________________________________________________________________________________________________");


        } catch (SQLException e) {
            System.out.println(e);
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

        return winners;
    }
}
