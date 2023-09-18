CREATE TABLE IF NOT EXISTS roles(
    usuario VARCHAR(45) NOT NULL,
    role VARCHAR (50) NOT NULL,
    KEY FK_usuario (usuario),
    CONSTRAINT FK_usuario
    FOREIGN KEY (usuario) REFERENCES pessoa (usuario)
);

INSERT INTO roles
VALUES ("PedroBosini","ROLE_ADMIN"),
       ("Janaina", "ROLE_USER");