package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Score;
import com.dbc.repository.ScoreRepository;
import java.util.List;

public class ScoreService {
    private ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public void listar() {
        try {
            List<Score> scoreList = scoreRepository.listar();
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
