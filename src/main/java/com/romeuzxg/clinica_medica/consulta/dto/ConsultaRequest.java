package com.romeuzxg.clinica_medica.consulta.dto;

import com.romeuzxg.clinica_medica.consulta.StatusConsulta;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ConsultaRequest(@NotBlank Long pacienteId, @NotBlank Long medicoId, @NotBlank LocalDateTime dataHora, @NotBlank StatusConsulta status) {
}
