package com.romeuzxg.clinica_medica.dto.request;

import com.romeuzxg.clinica_medica.entity.Consulta;

import java.time.LocalDateTime;

public record ConsultaRequest(Long pacienteId, Long medicoId, LocalDateTime dataHora, Enum<Consulta.Enums> status) {
}
