package com.romeuzxg.clinica_medica.especialidade.dto;

import jakarta.validation.constraints.NotBlank;

public record EspecialidadeRequest(@NotBlank String nome) {
}
