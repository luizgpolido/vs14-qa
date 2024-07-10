package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Battle;
import com.dbc.repository.BattleRepository;
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

//    public void remove(Integer id) {
//        try {
//            boolean removeBattle = battleRepository.remover(id);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    };

//    public void edit(Integer id, Battle battle) {
//        try {
//            boolean editBattle = battleRepository.editar(id, battle);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }


}
