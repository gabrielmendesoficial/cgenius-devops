CREATE TABLE CLIENTE(
    id INTEGER,
    nome VARCHAR(50),
    cpf VARCHAR(11) PRIMARY KEY,
    dtNascimento DATE,
    genero VARCHAR(10),
    cep CHAR(8),
    telefone VARCHAR(10),
    email VARCHAR(50),
    perfil VARCHAR(30));

CREATE TABLE ESPECIFICACAO(
    id INTEGER PRIMARY KEY,
    tipoCartaoCredito VARCHAR,
    gastoMensal DECIMAL(10,2),
    rendaMensal DECIMAL(10,2),
    viajaFrequentemente NUMBER(1),
    interesses VARCHAR(50),
    profissao VARCHAR(30), 
    dependentes NUMBER(1),
    cpfCliente VARCHAR(11),
    FOREIGN KEY (cpfCliente) REFERENCES CLIENTE(cpf));

CREATE TABLE ATENDENTE(
    id INTEGER,
    nome VARCHAR(50),
    cpf VARCHAR(11) PRIMARY KEY,
    setor VARCHAR(20),
    senha VARCHAR(10),
    perfil VARCHAR(30));
    
CREATE TABLE PLANO(
    nomePlano VARCHAR(30),
    id INTEGER PRIMARY KEY,
    descricaoPlano VARCHAR(100),
    valorPlano DECIMAL(10,2));

CREATE TABLE SCRIPT(
    id INTEGER PRIMARY KEY,
    descricaoScript CLOB,
    idPlano INTEGER,
    FOREIGN KEY (idPlano) REFERENCES PLANO(id));

CREATE TABLE VENDA(
    id INTEGER PRIMARY KEY,
    cpfAtendente VARCHAR(11),
    cpfCliente VARCHAR(11),
    idScript INTEGER,
    idPlano INTEGER,
    FOREIGN KEY (cpfAtendente) REFERENCES ATENDENTE(cpf),
    FOREIGN KEY (cpfCliente) REFERENCES CLIENTE(cpf),
    FOREIGN KEY (idScript) REFERENCES SCRIPT(id),
    FOREIGN KEY (idPlano) REFERENCES PLANO(id));


INSERT INTO CLIENTE (id, nome, cpf, dtNascimento, genero, cep, telefone, email, perfil) VALUES (1, 'John Doe', '12345678901', '1990-01-01', 'Male', '12345678', '1234567890', 'john.doe@example.com', 'Regular');

INSERT INTO ESPECIFICACAO (id, tipoCartaoCredito, gastoMensal, rendaMensal, viajaFrequentemente, interesses, profissao, dependentes, cpfCliente) VALUES (1, 'Visa', 1000.00, 5000.00, 1, 'Travel, Dining', 'Engineer', 2, '12345678901');

INSERT INTO ATENDENTE (id, nome, cpf, setor, senha, perfil) VALUES (1, 'Jane Smith', '98765432101', 'Customer Service', 'password', 'Regular');

INSERT INTO PLANO (nomePlano, id, descricaoPlano, valorPlano) VALUES ('Basic Plan', 1, 'Basic plan with limited features', 9.99);

INSERT INTO SCRIPT (id, descricaoScript, idPlano) VALUES (1, 'Script for Basic Plan', 1);

INSERT INTO VENDA (id, cpfAtendente, cpfCliente, idScript, idPlano) VALUES (1, '98765432101', '12345678901', 1, 1);

