package br.com.alura.forumHub.model.autenticacao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoAutenticacao(
        @NotBlank @Email String email,
        @NotBlank String senha
) {}
