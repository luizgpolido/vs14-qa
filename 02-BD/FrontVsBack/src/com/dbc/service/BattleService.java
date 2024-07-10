package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Battle;
import com.dbc.repository.BattleRepository;

import java.util.List;

public class BattleService {
    private BattleRepository battleRepository;

    public BattleService(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    public void insert(Battle finalBattle) {
        try {
            Battle insertBattle = (Battle) battleRepository.adicionar(finalBattle);
        } catch ( BancoDeDadosException e) {
            e.printStackTrace();
        }
    };

    public void remove(Integer id) {
        try {
            boolean removeBattle = battleRepository.remover(id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    };

    public void edit(Integer id, Battle battle) {
        try {
            boolean editBattle = battleRepository.editar(id, battle);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

//    public void list() {
//        try {
//            battleRepository.listar().forEach(System.out::println);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
}
