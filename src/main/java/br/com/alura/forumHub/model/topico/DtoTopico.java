package br.com.alura.forumHub.model.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        StatusTopico status,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
