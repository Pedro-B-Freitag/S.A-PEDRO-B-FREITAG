CREATE TABLE IF NOT EXISTS curso (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(45) NOT NULL,
  categoria VARCHAR(45) NULL,
  fornecedor VARCHAR(45) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  url VARCHAR(255) NOT NULL,
  presencial BOOLEAN NOT NULL,
  visualizacao INT NULL,
  gostei INT NULL,
  qtd_hrs VARCHAR(50) NULL,
  imagem BLOB
);
