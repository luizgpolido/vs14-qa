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
VALUES (SEQ_PAIS.NEXTVAL, 'Brasil');

INSERT INTO PAIS (id_pais, nome)
VALUES (SEQ_PAIS.NEXTVAL, 'Estados Unidos');

INSERT INTO ESTADO (id_estado, nome, id_pais)
VALUES (SEQ_ESTADO.NEXTVAL, 'São Paulo', (SELECT id_pais FROM PAIS WHERE nome = 'Brasil'));

INSERT INTO ESTADO (id_estado, nome, id_pais)
VALUES (SEQ_ESTADO.NEXTVAL, 'Rio de Janeiro', (SELECT id_pais FROM PAIS WHERE nome = 'Brasil'));

INSERT INTO ESTADO (id_estado, nome, id_pais)
VALUES (SEQ_ESTADO.NEXTVAL, 'California', (SELECT id_pais FROM PAIS WHERE nome = 'Estados Unidos'));

INSERT INTO ESTADO (id_estado, nome, id_pais)
VALUES (SEQ_ESTADO.NEXTVAL, 'New Testes', (SELECT id_pais FROM PAIS WHERE nome = 'Estados Unidos'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'São Paulo', (SELECT id_estado FROM ESTADO WHERE nome = 'São Paulo'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Campinas', (SELECT id_estado FROM ESTADO WHERE nome = 'São Paulo'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Rio de Janeiro', (SELECT id_estado FROM ESTADO WHERE nome = 'Rio de Janeiro'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Niterói', (SELECT id_estado FROM ESTADO WHERE nome = 'Rio de Janeiro'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Los Testes', (SELECT id_estado FROM ESTADO WHERE nome = 'California'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'San Testes', (SELECT id_estado FROM ESTADO WHERE nome = 'California'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'New Testes', (SELECT id_estado FROM ESTADO WHERE nome = 'New Testes'));

INSERT INTO CIDADE (id_cidade, nome, id_estado)
VALUES (SEQ_CIDADE.NEXTVAL, 'Salamanca', (SELECT id_estado FROM ESTADO WHERE nome = 'New Testes'));

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), (SELECT id_estado FROM ESTADO WHERE nome = 'São Paulo'), 'Centro');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), (SELECT id_estado FROM ESTADO WHERE nome = 'São Paulo'), 'Vila Mariana');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), (SELECT id_estado FROM ESTADO WHERE nome = 'São Paulo'), 'Cambuí');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), (SELECT id_estado FROM ESTADO WHERE nome = 'São Paulo'), 'Barão Geraldo');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), (SELECT id_estado FROM ESTADO WHERE nome = 'Rio de Janeiro'), 'Copacabana');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), (SELECT id_estado FROM ESTADO WHERE nome = 'Rio de Janeiro'), 'Ipanema');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói'), (SELECT id_estado FROM ESTADO WHERE nome = 'Rio de Janeiro'), 'Icaraí');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói'), (SELECT id_estado FROM ESTADO WHERE nome = 'Rio de Janeiro'), 'Centro');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes'), (SELECT id_estado FROM ESTADO WHERE nome = 'California'), 'Testelandia');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes'), (SELECT id_estado FROM ESTADO WHERE nome = 'California'), 'Bairro Doido');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes'), (SELECT id_estado FROM ESTADO WHERE nome = 'California'), 'Chinatown');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes'), (SELECT id_estado FROM ESTADO WHERE nome = 'California'), 'Jardim da Ponte');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes'), (SELECT id_estado FROM ESTADO WHERE nome = 'New Testes'), 'Manhattan');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes'), (SELECT id_estado FROM ESTADO WHERE nome = 'New Testes'), 'Brooklyn');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca'), (SELECT id_estado FROM ESTADO WHERE nome = 'New Testes'), 'Castellana');

INSERT INTO BAIRRO (id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca'), (SELECT id_estado FROM ESTADO WHERE nome = 'New Testes'), 'Goya');


INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 'Avenida Arcanjo Paulista', 233, 'Apto 101', '01310-100');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 'Rua Augusta', 533, 'Apto 202', '01310-200');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Vila Mariana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 'Rua Domingos de Morais', 2342, 'Apto 303', '04110-300');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Vila Mariana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo')), (SELECT id_cidade FROM CIDADE WHERE nome = 'São Paulo'), 'Rua Vergueiro', 22, 'Apto 404', '04110-400');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Cambuí' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 'Rua Coronel Quirino', 33, 'Apto 601', '13025-000');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Cambuí' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 'Rua Sampainho', 55, 'Apto 702', '13025-010');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Barão Geraldo' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 'Avenida D. Pedro II', 43, 'Casa 1', '13084-012');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Barão Geraldo' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Campinas'), 'Rua Rui Barbosa', 22, 'Casa 2', '13084-020');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Copacabana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 'Avenida Polo Norte', 123, 'Casa B', '22021-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Copacabana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 'Rua Barata', 456, 'Casa', '22051-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Ipanema' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 'Rua Visconde de Pirajá', 51, 'Apto 1203', '22410-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Ipanema' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Rio de Janeiro'), 'Rua Farme de Amoedo', 32, 'Apto 1304', '22420-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Icaraí' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói'), 'Rua Moreira César', 3254, 'Casa', '24230-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Icaraí' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói'), 'Avenida Sete de Teste', 112, 'Casa', '24230-002');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói'), 'Rua da Iraci', 23, 'Apto 16', '24020-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Centro' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Niterói'), 'Rua Visconde do Rio Branco', 45, 'Apto 1704', '24030-001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Testelandia' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes'), 'Testelandia', 67, 'Casa 3', '90028');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Testelandia' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes'), 'Rua Sunset', 11, 'Apto 1902', '90028');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Bairro Doido' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes'), 'Rodeo Drive', 2000, 'Apto 2001', '90210');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Bairro Doido' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Los Testes'), 'Santa Monica', 2100, 'Apto 2102', '90210');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Chinatown' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes'), 'Rua Grande Ave', 12, 'Apto 2201', '65775');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Chinatown' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes'), 'Stockton St', 34, 'Apto 2302', '24244');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Jardim da Ponte' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes'), 'Ponte St', 64, 'Apto 2401', '1234124');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Jardim da Ponte' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'San Testes'), 'Valencia St', 46, 'Apto 2502', '53455');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Manhattan' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes'), '5th Ave', 2600, 'Apto 2601', '10001');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Manhattan' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes'), 'Rua da Broadway', 21, 'Apto 2702', '34122');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Brooklyn' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes'), 'Flatbush Ave', 31, 'Apto 2801', '11201');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Brooklyn' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes')), (SELECT id_cidade FROM CIDADE WHERE nome = 'New Testes'), 'Rua Louca 45', 45, 'Apto 536', '11201');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Castellana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca'), 'Allen St', 3000, 'Apto 31', '14201');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Castellana' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca'), 'Virginia St', 3100, 'Apto 1', '14201');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Goya' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca'), 'Rua Louca 22', 22, 'Apto 2', '14222');

INSERT INTO ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_ENDERECO.NEXTVAL, (SELECT id_bairro FROM BAIRRO WHERE nome = 'Goya' AND id_cidade = (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca')), (SELECT id_cidade FROM CIDADE WHERE nome = 'Salamanca'), 'Rua Louca 123', 123, 'Apto 5', '14222');


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

SELECT ID_CIDADE ,COUNT(*) 
FROM ENDERECO
GROUP BY ID_CIDADE;

