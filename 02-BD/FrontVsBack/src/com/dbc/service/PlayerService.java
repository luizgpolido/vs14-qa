package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.PlayerRepository;
import com.dbc.model.Player;

public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public void insert(Player player) {
        try {
            playerRepository.adicionar(player);
        } catch ( BancoDeDadosException e) {
            e.printStackTrace();
        }
    };

    public void getPlayer(){};

    public int getPlayerId(String playerName) throws BancoDeDadosException {
       return playerRepository.findPlayerId(playerName);
    }


}
