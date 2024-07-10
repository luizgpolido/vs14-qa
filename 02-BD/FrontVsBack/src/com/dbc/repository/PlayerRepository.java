package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Battle;
import com.dbc.model.Player;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements Repository<Integer, Player> {


    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT PLAYER_SEQUENCE.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");

        }
        return null;
    }

    @Override
    public Player adicionar(Player player) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            player.setIdPlayer(proximoId);

            String sql = "INSERT INTO PLAYER\n" +
                    "(ID_PLAYER, NAME_PLAYER)\n" +
                    "VALUES(?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, player.getIdPlayer());
            stmt.setString(2, player.getName());

            int res = stmt.executeUpdate();
            System.out.println("adicionarBattle.res=" + res);
            return player;
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

            String sql = "DELETE FROM PLAYER WHERE id_player = ?";

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
    public boolean editar(Integer id, Player player) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PLAYER SET ");
            sql.append(" name_player = ? ");
            sql.append(" WHERE id_player = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, player.getName());
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
    public List<Player> listar() throws BancoDeDadosException {
        List<Player> players = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM PESSOA";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Player player = new Player();
                player.setIdPlayer(res.getInt("id_player"));
                player.setName(res.getString("name_player"));
                players.add(player);
            }
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
        return players;
    }
}

