package br.com.alura.forumHub.model;

public record DtoTopico(
        String titulo,
        String mensagem,
        StatusTopico status,
        String autor,
        String curso
) {
}
