CREATE TABLE pessoa(
	codigo BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(30) NOT NULL,
	ativo TINYINT(1) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(5),
	complemento VARCHAR(30),
	bairro VARCHAR(20),
	cep VARCHAR(10),
	cidade VARCHAR(20),
	estado VARCHAR(20)
) ENGINE=InnoDB CHARSET=utf8;


INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Leandro",1,"Rua Reinaldo silveira","20","casa 2","Jova Rural","02281236","São Paulo","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Lucas",1,"Rua Reinaldo silveira","20","casa 2","Jova Rural","02281236","São Paulo","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Paloma",1,"Rua Reinaldo silveira","20","casa 2","Jova Rural","02281236","São Paulo","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Nélio",1,"Rua Reinaldo silveira","20","casa 2","Jova Rural","02281236","São Paulo","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Maria",1,"Rua Reinaldo silveira","20","casa 2","Jova Rural","02281236","São Paulo","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Karoline",1,"Avenida Getulio vargas","1180","Ap 6 - 5º Andar","Piratininga","02675031","Osasco","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Rodrigo",1,"Avenida Getulio vargas","1180","Ap 6 - 5º Andar","Piratininga","02675031","Osasco","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Isadora",1,"Avenida Getulio vargas","1180","Ap 6 - 5º Andar","Piratininga","02675031","Osasco","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Nelson",1,"Avenida Getulio vargas","1180","Ap 6 - 5º Andar","Piratininga","02675031","Osasco","São Paulo");
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ("Nina",1,"Avenida Getulio vargas","1180","Ap 6 - 5º Andar","Piratininga","02675031","Osasco","São Paulo");