package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Battle;
import com.dbc.model.Player;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class BattleRepository implements Repository{
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_battle.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");

        }
        return null;
    }


    @Override
    public Object adicionar(Object battle) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            battle.setIdBattle(proximoId);

            String sql = "INSERT INTO BATTLE\n" +
                    "(ID_BATTLE, CHARACTER1_ID, CHARACTER2_ID,  WINNER_ID, BATTLE_DATETIME)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, battle.getIdBattle());
            stmt.setInt(2, player.getIdPlayer());
            stmt.setInt(3, player.getIdPlayer()); // Player 2
            stmt.setInt(4, battle.getWinnerId());
            stmt.setDate(5, Date.valueOf(LocalDate.now()));

            int res = stmt.executeUpdate();
            System.out.println("adicionarPessoa.res=" + res);
            return battle;
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

    @Override
    public boolean remover(Object id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Object id, Object objeto) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List listar() throws BancoDeDadosException {
        return List.of();
    }
}
