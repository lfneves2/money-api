CREATE TABLE lancamento(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo VARCHAR(20) NOT NULL,
	codigo_categoria BIGINT(20) NOT NULL,
	codigo_pessoa BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Salário mensal', '2017-06-10', NULL, 6500.00, 'Distribuição de lucros','RECEITA',1,1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Bahamas', '2017-02-10', '2017-02-10', 100.32, 'Distribuição de lucros','RECEITA',2,2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Top Club', '2017-06-10', NULL, 120, 'Distribuição de lucros','RECEITA',3,3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Distribuição de lucros','RECEITA',3,4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('DMAE', '2017-06-10', NULL, 200.30, 'Distribuição de lucros','RECEITA',3,5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Extra', '2017-03-10', NULL, 1010.32, 'Distribuição de lucros','RECEITA',4,6);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Bahamas', '2017-06-10', '2017-06-10', 500, 'Distribuição de lucros','RECEITA',1,7);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Top Club', '2017-03-10', NULL, 400.32, 'Distribuição de lucros','RECEITA',4,8);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Pneus', '2017-04-10', NULL, 665.33, 'Distribuição de lucros','RECEITA',5,10);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Café', '2017-06-10', '2017-06-10', 8.32, 'Distribuição de lucros','RECEITA',1,5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Eletrónicos', '2017-04-10', NULL, 1040.32, 'Distribuição de lucros','RECEITA',5,4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Instrumentos', '2017-06-10', NULL, 4.32, 'Distribuição de lucros','RECEITA',4,3);
