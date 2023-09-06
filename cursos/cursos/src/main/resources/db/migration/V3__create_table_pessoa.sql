CREATE TABLE IF NOT EXISTS pessoa (
  pessoa_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  pessoa_cpf VARCHAR(11) UNIQUE NULL,
  pessoa_nome VARCHAR(255) NOT NULL,
  pessoa_contato VARCHAR(11) NULL,
  pessoa_email VARCHAR(255) UNIQUE NOT NULL,
  pessoa_genero VARCHAR(45) NOT NULL,
  pessoa_data_nascimento VARCHAR(15) NOT NULL,
  pessoa_cep VARCHAR(8) NULL,
  pessoa_rua VARCHAR(255) NULL,
  pessoa_bairro VARCHAR(45) NULL,
  pessoa_cidade VARCHAR(45) NULL,
  pessoa_estado VARCHAR(2) NULL,
  pessoa_nr_residencia VARCHAR(45) NULL,
  pessoa_usuario VARCHAR(45) NULL,
  pessoa_senha VARCHAR(45) NOT NULL,
  pessoa_role VARCHAR(45) NOT NULL
);
