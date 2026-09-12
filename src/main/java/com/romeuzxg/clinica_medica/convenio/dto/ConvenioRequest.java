package com.romeuzxg.clinica_medica.convenio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConvenioRequest(@NotBlank String nome, @NotNull Long pacienteId) {
}
