package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Battle;

import java.sql.*;
import java.util.List;

public class BattleRepository implements Repository<Integer, Battle> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT BATTLE_SEQUENCE.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");

        }
        return null;
    }

    @Override
    public Battle adicionar(Battle battle) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            battle.setIdBattle(proximoId);

            String sql = "INSERT INTO BATTLE\n" +
                    "(ID_BATTLE, ID_WINNER, ID_LOSER)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, battle.getIdBattle());
            stmt.setInt(2, battle.getWinnerId());
            stmt.setInt(3, battle.getLoserId());

            int res = stmt.executeUpdate();
            System.out.println("adicionarBattle.res=" + res);
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
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM BATTLE WHERE id_battle = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("removerBatalhaPorId.res=" + res);

            return res > 0;
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
    public boolean editar(Integer id, Battle battle) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE BATTLE SET ");
            sql.append(" winner_id = ? ");
            sql.append(" WHERE id_battle = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, battle.getWinnerId());
            stmt.setInt(2, id);

            int res = stmt.executeUpdate();
            System.out.println("editarBatalha.res=" + res);

            return res > 0;
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
    public List<Battle> listar() throws BancoDeDadosException {
        return List.of();
    }
}






