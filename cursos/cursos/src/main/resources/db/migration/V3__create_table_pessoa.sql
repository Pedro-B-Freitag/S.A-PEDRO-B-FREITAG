CREATE TABLE IF NOT EXISTS pessoa(
  pessoa_id INT UNIQUE NOT NULL AUTO_INCREMENT,
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
  pessoa_usuario VARCHAR(45) PRIMARY KEY  NOT NULL,
  pessoa_senha VARCHAR(255) NOT NULL,
  pessoa_ativado tinyint DEFAULT(1),
  roles_id int ,
    KEY FK_roles_idx (roles_id),
    CONSTRAINT FK_ROLES FOREIGN KEY (roles_id) REFERENCES roles (id)
);

DELIMITER //
CREATE TRIGGER before_pessoa_insert
BEFORE INSERT ON pessoa
FOR EACH ROW
BEGIN
  IF NEW.pessoa_ativado IS NULL THEN
    SET NEW.pessoa_ativado = 1;
  END IF;
END;
//
DELIMITER ;


DELIMITER //

CREATE TRIGGER before_pessoa_inserts
BEFORE INSERT ON pessoa
FOR EACH ROW
BEGIN
  IF NEW.roles_id IS NULL THEN
    -- Select the latest inserted id from the roles table
    SET NEW.roles_id = 1;
  END IF;
END;
//

DELIMITER ;

INSERT INTO pessoa (pessoa_cpf,pessoa_nome,pessoa_contato,pessoa_email , pessoa_genero ,pessoa_data_nascimento, pessoa_cep,
                    pessoa_rua,pessoa_bairro ,pessoa_cidade,pessoa_estado, pessoa_nr_residencia,pessoa_usuario,pessoa_senha, pessoa_ativado, roles_id)
VALUES ("09004999906", "Pedro Bosini", "47988923944","pedro@gmail.com",
        "M", "2005-12-18","89037385", "Sabia","Agua Verde", "Blumenau",
        "SC", "79","PedroBosini","$2a$10$6CIrQ1mOGj3wxyDhB6zbhuJaR3jztI2nQ.ItZWmIvW5eDvUvQiXs6", 1, 2),

        ("45678912301","Janaina","47999999999", "jana@gmail.com","F",
         	"2000-11-12","38729548","Peixes","Agua Azul","Itapetinga",
         	"SP","45","Janaina","$2a$10$6CIrQ1mOGj3wxyDhB6zbhuJaR3jztI2nQ.ItZWmIvW5eDvUvQiXs6", 1, 1);

