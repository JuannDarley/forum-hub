DELETE FROM topicos;
ALTER TABLE topicos ADD CONSTRAINT fk_topicos_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id);