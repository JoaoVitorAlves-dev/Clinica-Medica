package com.romeuzxg.clinica_medica.medico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoRequest(@NotNull String nome, @NotNull String crm, @NotBlank Long especialidadeId) {
}
