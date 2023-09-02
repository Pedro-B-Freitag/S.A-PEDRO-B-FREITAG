CREATE TABLE IF NOT EXISTS curso (
  curso_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  curso_descricao VARCHAR(45) NOT NULL,
  curso_categoria VARCHAR(45) NULL,
  curso_fornecedor VARCHAR(45) NOT NULL,
  curso_nome VARCHAR(45) NOT NULL,
  curso_url VARCHAR(45) NOT NULL,
  curso_presencial CHAR(1) NULL,
  curso_img BLOB NULL,
  curso_visualizacao INT NULL,
  curso_gostei INT NULL,
  curso_qtd_hrs TIME NULL
)
