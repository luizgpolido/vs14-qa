

INSERT INTO FRONT_VS_BACK.PLAYER (id_player, name) VALUES (PLAYER_SEQUENCE.NEXTVAL, 'Rickson');
INSERT INTO FRONT_VS_BACK.PLAYER (id_player, name) VALUES (PLAYER_SEQUENCE.NEXTVAL, 'Luiz');
INSERT INTO FRONT_VS_BACK.PLAYER (id_player, name) VALUES (PLAYER_SEQUENCE.NEXTVAL, 'Mateus');

INSERT INTO FRONT_VS_BACK.GAME_CHARACTER(id_game_character, name) VALUES (1001, 'Javoso');
INSERT INTO FRONT_VS_BACK.GAME_CHARACTER(id_game_character, name) VALUES (1002, 'Reactero');
INSERT INTO FRONT_VS_BACK.GAME_CHARACTER(id_game_character, name) VALUES (1003, 'Potugolino');


INSERT INTO FRONT_VS_BACK.BATTLE (ID_BATTLE, ID_WINNER, ID_LOSER) VALUES(BATTLE_SEQUENCE.NEXTVAL, 1, 1001);
INSERT INTO FRONT_VS_BACK.BATTLE (ID_BATTLE, ID_WINNER, ID_LOSER) VALUES(BATTLE_SEQUENCE.NEXTVAL, 1, 1003);
INSERT INTO FRONT_VS_BACK.BATTLE (ID_BATTLE, ID_WINNER, ID_LOSER) VALUES(BATTLE_SEQUENCE.NEXTVAL, 2, 1002);
INSERT INTO FRONT_VS_BACK.BATTLE (ID_BATTLE, ID_WINNER, ID_LOSER) VALUES(BATTLE_SEQUENCE.NEXTVAL, 2, 1002);
INSERT INTO FRONT_VS_BACK.BATTLE (ID_BATTLE, ID_WINNER, ID_LOSER) VALUES(BATTLE_SEQUENCE.NEXTVAL, 2, 1003);
INSERT INTO FRONT_VS_BACK.BATTLE (ID_BATTLE, ID_WINNER, ID_LOSER) VALUES(BATTLE_SEQUENCE.NEXTVAL, 2, 1001);
INSERT INTO FRONT_VS_BACK.BATTLE (ID_BATTLE, ID_WINNER, ID_LOSER) VALUES(BATTLE_SEQUENCE.NEXTVAL, 3, 1001);
