//package com.dbc.repository;
//
//import com.dbc.exceptions.BancoDeDadosException;
//import com.dbc.model.Battle;
//import com.dbc.model.CharacterFight;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CharacterRepository implements Repository<Integer, CharacterFight> {
//
//    @Override
//    public Integer getProximoId(Connection connection) throws SQLException {
//        String sql = "SELECT CHARACTER_SEQUENCE.nextval mysequence from DUAL";
//
//        try( Statement stmt = connection.createStatement();
//             ResultSet res = stmt.executeQuery(sql)) {
//
//            if (res.next()) {
//                return res.getInt("mysequence");
//            }
//            return null;
//        }
//    }
//
//    @Override
//    public CharacterFight adicionar(CharacterFight characterFight) throws BancoDeDadosException {
//        Connection con = null;
//        try {
//            con = ConexaoBancoDeDados.getConnection();
//
//            Integer proximoId = this.getProximoId(con);
//            characterFight.setIdChar(proximoId); // TODO IMPLEMENTAR ID DE CHARACTER
//
//            String sql = "INSERT INTO GAME_CHARACTER\n" +
//                    "(ID_GAME_CHARACTER, NAME_CHARACTER)\n" +
//                    "VALUES(?, ?)\n";
//
//            PreparedStatement stmt = con.prepareStatement(sql);
//
//            //stmt.setInt(1, characterFight());
//            //.setString(2, battle.getIdPlayer1()); // TODO FAZER RELACIONAMENTO NAS CLASSES
//
//            int res = stmt.executeUpdate();
//            System.out.println("adicionarCharacter.res=" + res);
//            return battle;
//        } catch (SQLException e) {
//            throw new BancoDeDadosException(e.getCause());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    @Override
//    public boolean remover(Integer id) throws BancoDeDadosException {
//        Connection con = null;
//        try {
//            con = ConexaoBancoDeDados.getConnection();
//
//            String sql = "DELETE FROM GAME_CHARACTER WHERE id_game_character = ?";
//
//            PreparedStatement stmt = con.prepareStatement(sql);
//
//            stmt.setInt(1, id);
//
//            int res = stmt.executeUpdate();
//            System.out.println("removerGame_CharacterPorId.res=" + res);
//
//            return res > 0;
//        } catch (SQLException e) {
//            throw new BancoDeDadosException(e.getCause());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public boolean editar(Integer id, CharacterFight characterFight) throws BancoDeDadosException {
//        Connection con = null;
//        try {
//            con = ConexaoBancoDeDados.getConnection();
//
//            StringBuilder sql = new StringBuilder();
//            sql.append("UPDATE GAME_CHARACTER SET ");
//            sql.append(" name_character = ? ");
//            sql.append(" WHERE id_game_character = ? ");
//
//            PreparedStatement stmt = con.prepareStatement(sql.toString());
//
//            //.setInt(1, battle.getGameCharacter()); // TODO FAZER RELACIONAMENTO NAS CLASSES
//
//            int res = stmt.executeUpdate();
//            System.out.println("editarCharacter.res=" + res);
//
//            return res > 0;
//        } catch (SQLException e) {
//            throw new BancoDeDadosException(e.getCause());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public List<CharacterFight> listar() throws BancoDeDadosException {
//        List<CharacterFight> characterFights = new ArrayList<>();
//        Connection con = null;
//        try {
//            con = ConexaoBancoDeDados.getConnection();
//            Statement stmt = con.createStatement();
//
//            String sql = "SELECT * FROM GAME_CHARACTER";
//
//            ResultSet res = stmt.executeQuery(sql);
//
//            while (res.next()) {
//                CharacterFight characterFight = new CharacterFight() {
//                    @Override
//                    public String getName() { //TODO REFATORAR ABSTRACT?
//                        return "";
//                    }
//
//                    @Override
//                    public boolean deduceHitPoints(int damage) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean dodge() {
//                        return false;
//                    }
//
//                    @Override
//                    public int lightAttack(int strength) {
//                        return 0;
//                    }
//
//                    @Override
//                    public int heavyAttack(int strength) {
//                        return 0;
//                    }
//
//                    @Override
//                    public int specialAttack(int strength) {
//                        return 0;
//                    }
//                };
//                characterFights.setIdGameCharacter(res.getInt("id_game_character"));
//                characterFights.setGameCharacter(res.getInt("name_character"));
//                characterFights.add(characterFight);
//            }
//        } catch (SQLException e) {
//            throw new BancoDeDadosException(e.getCause());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return characterFights;
//    }
//}
//
//
//
