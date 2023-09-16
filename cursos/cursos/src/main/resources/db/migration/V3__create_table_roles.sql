CREATE TABLE IF NOT EXISTS roles(
    usuario VARCHAR(45) NOT NULL,
    role VARCHAR (50) NOT NULL,
    UNIQUE KEY roles_idx_1 (usuario,role),
    CONSTRAINT roles_ibfk_1
    FOREIGN KEY (usuario) REFERENCES pessoa (usuario)
);

INSERT INTO roles
VALUES ("PedroBosini","ROLE_ADMIN"),
       ("Janaina", "ROLE_USER");