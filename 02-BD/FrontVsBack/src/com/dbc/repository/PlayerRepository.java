package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlayerRepository implements Repository{
    @Override
    public Object getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Object adicionar(Object object) throws BancoDeDadosException {
        return null;
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
