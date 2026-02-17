package br.com.alura.forumHub.model.topico;

import java.time.LocalDateTime;

public record DtoListagemTopico(
        String titulo,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String curso
) {
    // Construtor que recebe a entidade para facilitar a conversão
    public DtoListagemTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getCurso()
        );
    }
}