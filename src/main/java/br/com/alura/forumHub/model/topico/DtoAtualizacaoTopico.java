package br.com.alura.forumHub.model.topico;

import jakarta.validation.constraints.NotNull;

public record DtoAtualizacaoTopico(
        String titulo,
        String mensagem,
        StatusTopico status

) {
}
