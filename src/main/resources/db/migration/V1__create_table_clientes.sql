CREATE TABLE CLIENTE(
    id INTEGER,
    nomeCliente VARCHAR(50),
    cpfCliente VARCHAR(11) PRIMARY KEY,
    dtNascimento DATE,
    genero VARCHAR(10),
    cep CHAR(8),
    telefone VARCHAR(10),
    email VARCHAR(50),
    perfilCliente VARCHAR(30));

CREATE TABLE ESPECIFICACAO(
    id INTEGER PRIMARY KEY,
    tipoCartaoCredito VARCHAR(3),
    gastoMensal DECIMAL(10,2),
    rendaMensal DECIMAL(10,2),
    viajaFrequentemente NUMBER(1),
    interesses VARCHAR(50),
    profissao VARCHAR(30), 
    dependentes NUMBER(1),
    cpfCliente VARCHAR(11),
    FOREIGN KEY (cpfCliente) REFERENCES CLIENTE(cpfCliente));

CREATE TABLE ATENDENTE(
    id INTEGER,
    nomeAtendente VARCHAR(50),
    cpfAtendente VARCHAR(11) PRIMARY KEY,
    setorAtendente VARCHAR(20),
    senhaAtendente VARCHAR(10),
    perfilAtendente VARCHAR(30));
    
CREATE TABLE PLANO(
    nomePlano VARCHAR(30),
    id INTEGER PRIMARY KEY,
    descricaoPlano VARCHAR(100),
    valorPlano DECIMAL(10,2));

CREATE TABLE SCRIPTS(
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
    FOREIGN KEY (cpfAtendente) REFERENCES ATENDENTE(cpfAtendente),
    FOREIGN KEY (cpfCliente) REFERENCES CLIENTE(cpfCliente),
    FOREIGN KEY (idScript) REFERENCES SCRIPTS(id),
    FOREIGN KEY (idPlano) REFERENCES PLANO(id));