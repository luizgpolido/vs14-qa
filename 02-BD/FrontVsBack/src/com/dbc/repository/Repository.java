package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<Integer, Object> {
    Integer getProximoId(Connection connection) throws SQLException;

    Object adicionar(Object object) throws BancoDeDadosException;

    boolean remover(Integer id) throws BancoDeDadosException;

    boolean editar(Integer id, Object object) throws BancoDeDadosException;

    List<java.lang.Object> listar() throws BancoDeDadosException;
}
