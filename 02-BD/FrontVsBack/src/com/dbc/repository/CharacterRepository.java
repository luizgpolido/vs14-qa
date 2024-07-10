package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.CharacterFight;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class CharacterRepository implements Repository<Integer, CharacterFight>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT CHARACTER_SEQUENCE.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");

        }
        return null;
    }

    @Override
    public CharacterFight adicionar(CharacterFight characterFight) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            characterFight.setIdChar(proximoId); // TODO IMPLEMENTAR ID DE CHARACTER

            String sql = "INSERT INTO GAME_CHARACTER\n" +
                    "(ID_GAME_CHARACTER, NAME_CHARACTER)\n" +
                    "VALUES(?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            //stmt.setInt(1, characterFight());
            //.setInt(2, battle.getIdPlayer1()); // TODO FAZER RELACIONAMENTO NAS CLASSES

            int res = stmt.executeUpdate();
            System.out.println("adicionarCharacter.res=" + res);
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
        return false;
    }

    @Override
    public boolean editar(Integer id, CharacterFight object) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Object> listar() throws BancoDeDadosException {
        return List.of();
    }


}
