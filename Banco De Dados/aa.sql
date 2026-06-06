CREATE TABLE sessao (
    id SERIAL PRIMARY KEY,
    ip VARCHAR(100) NOT NULL,
    codigo VARCHAR(100) NOT NULL UNIQUE,
    usuario VARCHAR(100) NOT NULL
);

	
CREATE TABLE log (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    id_sessao INTEGER NOT NULL,
    FOREIGN KEY (id_sessao) REFERENCES Sessao(id)
);

CREATE TABLE pagina (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL UNIQUE,
    titulo VARCHAR(100) NOT NULL,
    url VARCHAR(100) NOT NULL UNIQUE,
    codigo_html VARCHAR(100) NOT NULL,
    tamanho_real INTEGER NOT NULL DEFAULT 0,
    tamanho_do_arquivo INTEGER NOT NULL DEFAULT 0,
    texto_puro VARCHAR(100) NOT NULL,
    tipo_de_conteudo VARCHAR(100) NOT NULL
);

CREATE TABLE requisicao (
    id SERIAL PRIMARY KEY,
    id_sessao INTEGER NOT NULL,
    id_pagina INTEGER NOT NULL,
    codigo VARCHAR(100) NOT NULL,
    tempo_transcorrido INTEGER NOT NULL DEFAULT 0,
    carimbo_de_tempo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    codigo_http VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_sessao) REFERENCES Sessao(id),
    FOREIGN KEY (id_pagina) REFERENCES Pagina(id)
);

CREATE TABLE link (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL UNIQUE,
    texto VARCHAR(100) NOT NULL,
    url VARCHAR(100) NOT NULL UNIQUE,
    vizinhanca INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE pagina_link (
    id_pagina INTEGER NOT NULL,
    id_link INTEGER NOT NULL,
    PRIMARY KEY (id_pagina, id_link),
    FOREIGN KEY (id_pagina) REFERENCES Pagina(id),
    FOREIGN KEY (id_link) REFERENCES Link(id)
);






INSERT INTO sessao (ip, codigo, usuario)
VALUES
	('123.105.133.13', 'F01-APR3S3NTAD0RA', 'Carly'),
	('162.05.151.233', 'F01-L0CONA', 'Sam'),
	('173.205.121.43', 'F01-M3UAMOR', 'Fred');

INSERT INTO log (codigo,nome,id_sessao)
VALUES
	('123', 'Gustavo', 002),
	('124', 'Ana', 003),
	('125', 'Hellen', 004);


INSERT INTO pagina (codigo, titulo, url, codigo_html, tamanho_real, tamanho_do_arquivo, texto_puro, tipo_de_conteudo)
VALUES
	('001', 'Página Inicial', '/index.html', '<html>...</html>', 2048, 2100, 'Bem-vindo ao site', 'texto'),
	('002', 'Sobre Nós', '/sobre.html', '<html>...</html>', 1024, 1100, 'Informações sobre a empresa', 'texto'),
	('003', 'Contato', '/contato.html', '<html>...</html>', 800, 850, 'Formulário de contato', 'texto');

INSERT INTO requisicao (id_sessao, id_pagina, codigo, tempo_transcorrido, codigo_http)
VALUES
	(12, 12, '201', 120, '200'),
	(23, 23, '202', 95, '404'),
	(14, 34, '203', 60, '200');

INSERT INTO link (codigo, texto, url, vizinhanca)
VALUES
	('007', 'Ir para Sobre Nós', '/sobre.html', 2),
	('009', 'Voltar ao Início', '/index.html', 3),
	('010', 'Entre em Contato', '/contato.html', 1);

INSERT INTO pagina_link (id_pagina, id_link)
VALUES
	(001, 007),
	(002, 009),
	(003, 010);

CREATE TABLE cidade( idcidade serial primary key, nomecidade varchar(100) );

SELECT nomecidade

FROM cidade

ORDER BY nomecidade ASC;





	