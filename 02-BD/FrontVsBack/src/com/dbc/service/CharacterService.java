package com.dbc.service;

import com.dbc.repository.CharacterRepository;

public class CharacterService {
    private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
}
