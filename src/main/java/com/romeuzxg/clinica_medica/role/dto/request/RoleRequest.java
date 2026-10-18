package com.romeuzxg.clinica_medica.role.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequest(
        @NotBlank String nome
) {
}
