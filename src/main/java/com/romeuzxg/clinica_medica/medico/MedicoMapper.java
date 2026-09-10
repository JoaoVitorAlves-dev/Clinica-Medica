package com.romeuzxg.clinica_medica.medico;

import com.romeuzxg.clinica_medica.medico.dto.MedicoRequest;
import com.romeuzxg.clinica_medica.medico.dto.MedicoResponse;
import com.romeuzxg.clinica_medica.especialidade.Especialidade;
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
