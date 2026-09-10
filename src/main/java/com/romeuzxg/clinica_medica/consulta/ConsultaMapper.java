package com.romeuzxg.clinica_medica.consulta;

import com.romeuzxg.clinica_medica.consulta.dto.ConsultaRequest;
import com.romeuzxg.clinica_medica.consulta.dto.ConsultaResponse;
import com.romeuzxg.clinica_medica.medico.Medico;
import com.romeuzxg.clinica_medica.paciente.Paciente;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConsultaMapper {

    public Consulta toEntity(ConsultaRequest consultaRequest, Paciente paciente, Medico medico) {
        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataHora(consultaRequest.dataHora());
        consulta.setStatus(consultaRequest.status());
        return consulta;
    }

    public ConsultaResponse toDTO(Consulta consulta) {
        return new ConsultaResponse(consulta.getId(), consulta.getPaciente().getId(), consulta.getMedico().getId(),
                consulta.getDataHora(), consulta.getStatus());
    }

}
