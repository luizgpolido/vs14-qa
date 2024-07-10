package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<Integer, CharacterFight> {
    Integer getProximoId(Connection connection) throws SQLException;

    CharacterFight adicionar(CharacterFight object) throws BancoDeDadosException;

    boolean remover(Integer id) throws BancoDeDadosException;

    boolean editar(Integer id, CharacterFight objeto) throws BancoDeDadosException;

    List<CharacterFight> listar() throws BancoDeDadosException;
}
