package br.com.alura.forumHub.model.topico;

import br.com.alura.forumHub.model.curso.NomeCurso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        StatusTopico status,
        @NotNull
        NomeCurso curso
) {
}
