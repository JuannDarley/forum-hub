ALTER TABLE topicos ADD COLUMN curso_id BIGINT NOT NULL;
ALTER TABLE topicos ADD CONSTRAINT fk_topicos_curso FOREIGN KEY (curso_id) REFERENCES cursos(id);