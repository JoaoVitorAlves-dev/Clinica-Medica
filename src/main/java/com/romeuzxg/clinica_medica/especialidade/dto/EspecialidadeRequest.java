package com.romeuzxg.clinica_medica.especialidade.dto;

import jakarta.validation.constraints.NotNull;

public record EspecialidadeRequest(@NotNull String nome) {
}
