package com.romeuzxg.clinica_medica.mapper;

import com.romeuzxg.clinica_medica.dto.request.ConsultaRequest;
import com.romeuzxg.clinica_medica.dto.response.ConsultaResponse;
import com.romeuzxg.clinica_medica.entity.Consulta;
import com.romeuzxg.clinica_medica.entity.Medico;
import com.romeuzxg.clinica_medica.entity.Paciente;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConsultaMapper {

    public Consulta toEntity(ConsultaRequest consultaRequest, Paciente paciente, Medico medico) {
        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataHora(consultaRequest.dataHora());
        consulta.setStatus((Consulta.Enums) consultaRequest.status());
        return consulta;
    }

    public ConsultaResponse toDTO(Consulta consulta) {
        return new ConsultaResponse(consulta.getId(), consulta.getPaciente().getId(), consulta.getMedico().getId(),
                consulta.getDataHora(), consulta.getStatus());
    }

}
