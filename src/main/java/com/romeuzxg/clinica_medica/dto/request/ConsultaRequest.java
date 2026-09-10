package com.romeuzxg.clinica_medica.dto.request;

import com.romeuzxg.clinica_medica.enums.StatusConsulta;

import java.time.LocalDateTime;

public record ConsultaRequest(Long pacienteId, Long medicoId, LocalDateTime dataHora, StatusConsulta status) {
}
