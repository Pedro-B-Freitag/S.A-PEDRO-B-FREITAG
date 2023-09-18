CREATE TABLE IF NOT EXISTS roles(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    usuario VARCHAR(45) NOT NULL,
    role VARCHAR (50) NOT NULL DEFAULT ("ROLE_USER"),
    KEY FK_usuario (usuario),
    CONSTRAINT FK_usuario
    FOREIGN KEY (usuario) REFERENCES pessoa (usuario)
);

INSERT INTO roles (usuario,role)
VALUES ("PedroBosini","ROLE_ADMIN"),
       ("Janaina", "ROLE_USER");