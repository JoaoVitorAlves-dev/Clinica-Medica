package com.romeuzxg.clinica_medica.dto.response;

import com.romeuzxg.clinica_medica.enums.StatusConsulta;

import java.time.LocalDateTime;

public record ConsultaResponse(Long id, Long pacienteId, Long medicoId, LocalDateTime dataHora, StatusConsulta status) {
}
