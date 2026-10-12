package com.romeuzxg.clinica_medica.usuarios.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequest(
        @NotBlank String nome
) {
}
