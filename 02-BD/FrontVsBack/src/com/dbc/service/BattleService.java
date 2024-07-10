package com.dbc.service;

import com.dbc.repository.BattleRepository;

public class BattleService {
    private BattleRepository battleRepository;

    public BattleService(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }
}
