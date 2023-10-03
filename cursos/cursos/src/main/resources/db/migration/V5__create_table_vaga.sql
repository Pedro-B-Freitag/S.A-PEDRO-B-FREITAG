CREATE TABLE IF NOT EXISTS vaga (
	empresa_nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(500) NOT NULL,
	cargo VARCHAR(45) NOT NULL,
	data_vaga  VARCHAR(45),
	data_prazo VARCHAR(45)  NULL DEFAULT NULL,
	categoria VARCHAR(45) NOT NULL ,
	quantidade VARCHAR(10) NOT NULL ,
	url VARCHAR(255) NOT NULL,
	id INT UNIQUE NOT NULL AUTO_INCREMENT,
    CONSTRAINT fk_vaga_empresa FOREIGN KEY (empresa_nome) REFERENCES empresa (nome)
);
