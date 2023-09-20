CREATE TABLE IF NOT EXISTS pessoa(
  id INT UNIQUE NOT NULL AUTO_INCREMENT,
  cpf VARCHAR(11) UNIQUE NULL,
  nome VARCHAR(255) NOT NULL,
  contato VARCHAR(11) NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  genero VARCHAR(45) NOT NULL,
  data_nascimento VARCHAR(15) NOT NULL,
  cep VARCHAR(8) NULL,
  rua VARCHAR(255) NULL,
  bairro VARCHAR(45) NULL,
  cidade VARCHAR(45) NULL,
  estado VARCHAR(2) NULL,
  nr_residencia VARCHAR(45) NULL,
  usuario VARCHAR(45) PRIMARY KEY  NOT NULL,
  senha VARCHAR(255) NOT NULL,
  ativado tinyint DEFAULT(1),
  roles_id int ,
    KEY FK_roles_idx (roles_id),
    CONSTRAINT FK_ROLES FOREIGN KEY (roles_id) REFERENCES roles (id)
);

DELIMITER //
CREATE TRIGGER before_pessoa_insert
BEFORE INSERT ON pessoa
FOR EACH ROW
BEGIN
  IF NEW.ativado IS NULL THEN
    SET NEW.ativado = 1;
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

INSERT INTO pessoa (cpf,nome,contato,email , genero ,data_nascimento, cep,
                    rua,bairro ,cidade,estado, nr_residencia,usuario,senha, ativado, roles_id)
VALUES ("09004999906", "Pedro Bosini", "47988923944","pedro@gmail.com",
        "M", "2005-12-18","89037385", "Sabia","Agua Verde", "Blumenau",
        "SC", "79","PedroBosini","{bcrypt}$2a$10$6CIrQ1mOGj3wxyDhB6zbhuJaR3jztI2nQ.ItZWmIvW5eDvUvQiXs6", 1, 2),

        ("45678912301","Janaina","47999999999", "jana@gmail.com","F",
         	"2000-11-12","38729548","Peixes","Agua Azul","Itapetinga",
         	"SP","45","Janaina","{bcrypt}$2a$10$6CIrQ1mOGj3wxyDhB6zbhuJaR3jztI2nQ.ItZWmIvW5eDvUvQiXs6", 1, 1);

