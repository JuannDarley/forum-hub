CREATE TABLE cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO cursos (nome, categoria) VALUES ('Java', 'Back-end');
INSERT INTO cursos (nome, categoria) VALUES ('JavaScript', 'Front-end');
INSERT INTO cursos (nome, categoria) VALUES ('Banco de Dados', 'Banco de Dados');