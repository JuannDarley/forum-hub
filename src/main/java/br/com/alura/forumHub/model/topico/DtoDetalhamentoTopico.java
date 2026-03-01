package br.com.alura.forumHub.model.topico;

import br.com.alura.forumHub.model.topico.StatusTopico;
import br.com.alura.forumHub.model.topico.Topico;

import java.time.LocalDateTime;

public record DtoDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String curso,
        String autor
) {

    public DtoDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getCurso().getNome(),
                topico.getAutor().getNome()
        );
    }
}