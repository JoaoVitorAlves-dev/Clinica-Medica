package com.romeuzxg.clinica_medica.consulta.dto;

import com.romeuzxg.clinica_medica.consulta.StatusConsulta;

import java.time.LocalDateTime;

public record ConsultaRequest(Long pacienteId, Long medicoId, LocalDateTime dataHora, StatusConsulta status) {
}
