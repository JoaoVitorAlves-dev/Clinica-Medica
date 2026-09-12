package com.romeuzxg.clinica_medica.consulta.dto;

import com.romeuzxg.clinica_medica.consulta.StatusConsulta;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequest(@NotNull Long pacienteId, @NotNull Long medicoId, @NotNull LocalDateTime dataHora, @NotNull StatusConsulta status) {
}
