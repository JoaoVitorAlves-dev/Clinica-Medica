package com.romeuzxg.clinica_medica.usuarios.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank @Size(min = 12, max = 50) String nome,
        @NotBlank @Size(min = 8, max = 100) String senha
) {
}
