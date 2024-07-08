--Create Table
CREATE TABLE PAIS(
id_pais NUMBER(38,0) PRIMARY KEY NOT NULL,
nome VARCHAR2(50) NOT NULL
);

CREATE TABLE ESTADO(
id_estado NUMBER(38,0) PRIMARY KEY NOT NULL,
id_pais NUMBER(38,0) NOT NULL,
nome VARCHAR2(50) NOT NULL,
CONSTRAINT FK_ESTADO_PAIS FOREIGN KEY (id_pais) REFERENCES PAIS (id_pais)
);

CREATE TABLE CIDADE(
id_cidade NUMBER(38,0) NOT NULL,
id_estado NUMBER(38,0) NOT NULL,
nome VARCHAR2(50) NOT NULL,
PRIMARY KEY(id_cidade, id_estado),
CONSTRAINT FK_CIDADE_ESTADO FOREIGN KEY (id_estado) REFERENCES ESTADO (id_estado)
);

CREATE TABLE BAIRRO(
id_bairro NUMBER(38,0) NOT NULL,
id_cidade NUMBER(38,0) NOT NULL,
id_estado NUMBER(38,0) NOT NULL,
nome VARCHAR2(50) NOT NULL,
PRIMARY KEY(id_bairro, id_cidade),
CONSTRAINT FK_BAIRRO_CIDADE FOREIGN KEY (id_cidade, id_estado) REFERENCES CIDADE (id_cidade, id_estado)
);

CREATE TABLE ENDERECO(
id_endereco NUMBER(38,0) PRIMARY KEY NOT NULL,
id_bairro NUMBER(38,0) NOT NULL,
id_cidade NUMBER(38,0) NOT NULL,
logradouro VARCHAR2(255) NOT NULL,
numero NUMBER(38,0) NOT NULL,
complemento VARCHAR2(100) NOT NULL,
cep CHAR(9) NOT NULL,
CONSTRAINT FK_ENDERECO_BAIRRO FOREIGN KEY (id_bairro, id_cidade) REFERENCES BAIRRO (id_bairro, id_cidade)
);

--Sequences
CREATE SEQUENCE VEM_SER.SEQ_PAIS
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_ESTADO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_CIDADE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;


--Inserts

INSERT INTO PAIS (id_pais, nome)
VALUES (SEQ_PAIS.NEXTVAL, 'Argentina');

INSERT INTO PAIS (id_pais, nome)
VALUES (SEQ_PAIS.NEXTVAL, 'Bolivia');

INSERT INTO ESTADO (id_estado, nome, id_pais)
VALUES (SEQ_ESTADO.NEXTVAL, 'Buenos Aires', (SELECT id_pais FROM PAIS WHERE nome = 'Argentina'));

INSERT INTO ESTADO (id_estado, nome, id_pais)
VALUES (SEQ_ESTADO.NEXTVAL, 'Córdoba', (SELECT id_pais FROM PAIS WHERE nome = 'Argentina'));

INSERT INTO ESTADO (id_estado, nome, id_pais)
VALUES (SEQ_ESTADO.NEXTVAL, 'La Paz', (SELECT id_pais FROM PAIS WHERE nome = 'Bolivia'));

INSERT INTO ESTADO (id_estado, nome, id_pais)
VALUES (SEQ_ESTADO.NEXTVAL, 'Santa Cruz', (SELECT id_pais FROM PAIS WHERE nome = 'Bolivia'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Buenos Aires', (SELECT id_estado FROM ESTADO WHERE nome = 'Buenos Aires'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'La Plata', (SELECT id_estado FROM ESTADO WHERE nome = 'Buenos Aires'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Córdoba', (SELECT id_estado FROM ESTADO WHERE nome = 'Córdoba'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Villa Carlos Paz', (SELECT id_estado FROM ESTADO WHERE nome = 'Córdoba'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'La Paz', (SELECT id_estado FROM ESTADO WHERE nome = 'La Paz'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'El Alto', (SELECT id_estado FROM ESTADO WHERE nome = 'La Paz'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Santa Cruz de la Sierra', (SELECT id_estado FROM ESTADO WHERE nome = 'Santa Cruz'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Montero', (SELECT id_estado FROM ESTADO WHERE nome = 'Santa Cruz'));

-- Inserindo bairros
INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires'), (SELECT id_estado FROM ESTADO WHERE nome = 'Buenos Aires'), 'Palermo');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires'), (SELECT id_estado FROM ESTADO WHERE nome = 'Buenos Aires'), 'Recoleta');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata'), (SELECT id_estado FROM ESTADO WHERE nome = 'Buenos Aires'), 'Tolosa');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata'), (SELECT id_estado FROM ESTADO WHERE nome = 'Buenos Aires'), 'City Bell');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba'), (SELECT id_estado FROM ESTADO WHERE nome = 'Córdoba'), 'Nueva Córdoba');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba'), (SELECT id_estado FROM ESTADO WHERE nome = 'Córdoba'), 'Alta Córdoba');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz'), (SELECT id_estado FROM ESTADO WHERE nome = 'Córdoba'), 'Centro');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz'), (SELECT id_estado FROM ESTADO WHERE nome = 'Córdoba'), 'Las Rosas');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz'), (SELECT id_estado FROM ESTADO WHERE nome = 'La Paz'), 'Sopocachi');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz'), (SELECT id_estado FROM ESTADO WHERE nome = 'La Paz'), 'San Jorge');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto'), (SELECT id_estado FROM ESTADO WHERE nome = 'La Paz'), 'Ciudad Satélite');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto'), (SELECT id_estado FROM ESTADO WHERE nome = 'La Paz'), 'Villa Adela');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra'), (SELECT id_estado FROM ESTADO WHERE nome = 'Santa Cruz'), 'Equipetrol');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra'), (SELECT id_estado FROM ESTADO WHERE nome = 'Santa Cruz'), 'Las Palmas');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Montero'), (SELECT id_estado FROM ESTADO WHERE nome = 'Santa Cruz'), 'Centro');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Montero'), (SELECT id_estado FROM ESTADO WHERE nome = 'Santa Cruz'), 'Villa Cochabamba');

-- Inserindo endereços
INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Palermo' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires'), 'Avenida Santa Fe', 233, 'Apto 101', '1414');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Palermo' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires'), 'Calle Thames', 533, 'Apto 202', '1414');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Recoleta' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires'), 'Avenida Alvear', 2342, 'Apto 303', '1425');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Recoleta' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Buenos Aires'), 'Calle Posadas', 22, 'Apto 404', '1425');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Tolosa' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata')), (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata'), 'Calle 528', 112, 'Casa 1', '1900');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Tolosa' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata')), (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata'), 'Calle 30', 314, 'Casa 2', '1900');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'City Bell' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata')), (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata'), 'Calle Cantilo', 245, 'Casa 3', '1896');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'City Bell' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata')), (SELECT id_cidade FROM CIDADE WHERE nome = 'La Plata'), 'Calle 473', 451, 'Casa 4', '1896');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Nueva Córdoba' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba'), 'Avenida Hipólito Yrigoyen', 23, 'Depto 5', '5000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Nueva Córdoba' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba'), 'Calle Paraná', 105, 'Depto 6', '5000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Alta Córdoba' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba'), 'Avenida Juan B. Justo', 667, 'Depto 7', '5000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Alta Córdoba' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Córdoba'), 'Calle Sucre', 333, 'Depto 8', '5000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz'), 'Avenida San Martín', 102, 'Casa 9', '5152');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz'), 'Calle Libertad', 305, 'Casa 10', '5152');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Las Rosas' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz'), 'Calle Las Heras', 456, 'Casa 11', '5152');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Las Rosas' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Villa Carlos Paz'), 'Calle Mendoza', 789, 'Casa 12', '5152');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Sopocachi' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz')), (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz'), 'Calle Sánchez Lima', 100, 'Apto 201', '1234');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Sopocachi' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz')), (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz'), 'Calle Belisario Salinas', 200, 'Apto 301', '1234');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'San Jorge' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz')), (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz'), 'Avenida Arce', 1500, 'Apto 401', '5678');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'San Jorge' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz')), (SELECT id_cidade FROM CIDADE WHERE nome = 'La Paz'), 'Calle 8 de Calacoto', 1800, 'Apto 501', '5678');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Ciudad Satélite' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto')), (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto'), 'Calle 12 de Octubre', 1020, 'Casa 13', '1122');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Ciudad Satélite' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto')), (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto'), 'Avenida Juan Pablo II', 2020, 'Casa 14', '1122');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Villa Adela' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto')), (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto'), 'Calle 14', 132, 'Casa 15', '2211');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Villa Adela' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto')), (SELECT id_cidade FROM CIDADE WHERE nome = 'El Alto'), 'Avenida 16 de Julio', 456, 'Casa 16', '2211');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Equipetrol' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra'), 'Avenida San Martín', 1200, 'Apto 601', '7000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Equipetrol' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra'), 'Calle Los Cusis', 1300, 'Apto 701', '7000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Las Palmas' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra'), 'Avenida Roca y Coronado', 1234, 'Casa 17', '7100');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Las Palmas' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Santa Cruz de la Sierra'), 'Calle 24 de Septiembre', 567, 'Casa 18', '7100');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Montero')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Montero'), 'Avenida Warnes', 102, 'Casa 19', '7200');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Montero')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Montero'), 'Calle Sucre', 203, 'Casa 20', '7200');




--Selects
SELECT nome 
FROM VEM_SER.PAIS 
ORDER BY nome DESC;

SELECT logradouro, cep
FROM VEM_SER.ENDERECO
WHERE UPPER(logradouro) LIKE 'A%';

--Seleciona todos os dados do endereço
SELECT *
FROM VEM_SER.ENDERECO
WHERE TRIM(cep) LIKE '%0';  

SELECT *
FROM VEM_SER.ENDERECO
WHERE NUMERO BETWEEN 1 AND 100;

SELECT *
FROM VEM_SER.ENDERECO
WHERE logradouro LIKE 'Rua%' 
ORDER BY cep DESC; 

SELECT COUNT(*) 
FROM ENDERECO;

SELECT ID_CIDADE , COUNT(*) AS quantidade_cidades 
FROM ENDERECO
GROUP BY ID_CIDADE;

