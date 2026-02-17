package br.com.alura.forumHub.model.topico;

public record DtoAtualizacaoTopico(
        Long id,
        String titulo,
        String mensagem,
        StatusTopico status

) {
}
