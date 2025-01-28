CREATE DATABASE controle_chaves;

USE controle_chaves;

CREATE TABLE Chaves (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    status VARCHAR(50) DEFAULT 'Disponível'
);

CREATE TABLE Funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    departamento VARCHAR(255)
);

CREATE TABLE Registros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    chave_id INT,
    funcionario_id INT,
    data_retirada DATETIME,
    data_devolucao DATETIME,
    FOREIGN KEY (chave_id) REFERENCES Chaves(id),
    FOREIGN KEY (funcionario_id) REFERENCES Funcionarios(id)
);

SHOW DATABASES;
SELECT * FROM Chaves LIMIT 10;
SELECT * FROM Chaves;
SELECT COUNT(*) FROM Chaves;  -- Retorna o número total de registros na tabela Chaves
SELECT * FROM Funcionarios;
SELECT * FROM Registros;

DESCRIBE Chaves;
DESCRIBE Funcionarios;
DESCRIBE Registros;

INSERT INTO funcionarios (nome, cargo, salario) VALUES ('Teste', 'Desenvolvedor', 3000.00);
SELECT * FROM Registros WHERE id = 4;
ALTER TABLE Registros ADD COLUMN status VARCHAR(20) DEFAULT 'Retirada';
UPDATE Registros SET status = 'Devolvida' WHERE id = 4;
