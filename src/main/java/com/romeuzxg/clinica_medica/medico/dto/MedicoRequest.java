package com.romeuzxg.clinica_medica.medico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoRequest(@NotBlank String nome, @NotBlank String crm, @NotNull Long especialidadeId) {
}
