package com.romeuzxg.clinica_medica.mapper;

import com.romeuzxg.clinica_medica.dto.request.MedicoRequest;
import com.romeuzxg.clinica_medica.dto.response.MedicoResponse;
import com.romeuzxg.clinica_medica.entity.Especialidade;
import com.romeuzxg.clinica_medica.entity.Medico;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MedicoMapper {

    public Medico toEntity(MedicoRequest medicoRequest, Especialidade especialidade) {
        Medico medico = new Medico();
        medico.setNome(medicoRequest.nome());
        medico.setCrm(medicoRequest.crm());
        medico.setEspecialidade(especialidade);
        return medico;
    }

    public MedicoResponse toDTO(Medico medico) {
        return new MedicoResponse(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade().getId());
    }

}
