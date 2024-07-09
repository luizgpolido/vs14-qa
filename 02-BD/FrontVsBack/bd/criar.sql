-- CREATE TABLE PLAYER (
--     id_player NUMBER NOT NULL,
--     name VARCHAR2(64) NOT NULL,
--     PRIMARY KEY(id_player)
-- );

-- CREATE TABLE CLASSIFICACAO (
--     id_classificacao NUMBER NOT NULL,
--     id_player NUMBER NOT NULL,
--     score NUMBER NOT NULL,
--     PRIMARY KEY(id_classificacao),
--     FOREIGN KEY(id_player) REFERENCES PLAYER(id_player)
-- );


-- CREATE SEQUENCE SEQ_PLAYER
-- START WITH 1
-- INCREMENT BY 1
-- NOCACHE;


-- CREATE SEQUENCE SEQ_CLASSIFICACAO
-- START WITH 1
-- INCREMENT BY 1
-- NOCACHE;

CREATE USER FRONT_VS_BACK IDENTIFIED BY oracle;

GRANT CONNECT TO FRONT_VS_BACK;
GRANT RESOURCE TO FRONT_VS_BACK;
GRANT DBA TO FRONT_VS_BACK;
GRANT CREATE SESSION TO FRONT_VS_BACK;
GRANT CREATE VIEW TO FRONT_VS_BACK;
GRANT CREATE PROCEDURE TO FRONT_VS_BACK;
GRANT CREATE SEQUENCE TO FRONT_VS_BACK;
GRANT UNLIMITED TABLESPACE TO FRONT_VS_BACK;
GRANT CREATE MATERIALIZED VIEW TO FRONT_VS_BACK;
GRANT CREATE TABLE TO FRONT_VS_BACK;
GRANT GLOBAL QUERY REWRITE TO FRONT_VS_BACK;
GRANT SELECT ANY TABLE TO FRONT_VS_BACK;

ALTER SESSION SET CURRENT_SCHEMA=FRONT_VS_BACK;


CREATE TABLE FRONT_VS_BACK.PLAYER(
	id_player NUMERIC NOT NULL,
	name_player VARCHAR(200) NOT NULL,
        PRIMARY KEY(id_player)
);

CREATE SEQUENCE FRONT_VS_BACK.PLAYER_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE TABLE FRONT_VS_BACK.GAME_CHARACTER(
	id_game_character NUMERIC NOT NULL,
	name_character VARCHAR(200) NOT NULL,
	PRIMARY KEY(id_game_character)
);

CREATE SEQUENCE FRONT_VS_BACK.CHARACTER_SEQUENCE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE TABLE FRONT_VS_BACK.BATTLE (
    id_battle NUMBER NOT NULL,
    character1_id NUMBER NOT NULL,
    character2_id NUMBER NOT NULL,
    winner_id NUMBER NOT NULL,
    battle_datetime TIMESTAMP NOT NULL,
    PRIMARY KEY(id_battle),
    CONSTRAINT fk_character1 FOREIGN KEY (character1_id) REFERENCES FRONT_VS_BACK.GAME_CHARACTER(id_game_character),
    CONSTRAINT fk_character2 FOREIGN KEY (character2_id) REFERENCES FRONT_VS_BACK.GAME_CHARACTER(id_game_character),
    CONSTRAINT fk_winner FOREIGN KEY (winner_id) REFERENCES FRONT_VS_BACK.GAME_CHARACTER(id_game_character)
);




-- |id_player|nome|
-- |id_game_character|nome|
-- |id_battle|DATE|id_winner|id_loser| --> (calcular score com base nas vezes q id_winner aparece)

SELECT COUNT(b.id_winner),    FROM BATTLE b
LEFT JOIN





