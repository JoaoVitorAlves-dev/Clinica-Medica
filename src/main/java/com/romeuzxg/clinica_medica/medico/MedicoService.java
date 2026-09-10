package com.romeuzxg.clinica_medica.medico;

import com.romeuzxg.clinica_medica.medico.dto.MedicoRequest;
import com.romeuzxg.clinica_medica.medico.dto.MedicoResponse;
import com.romeuzxg.clinica_medica.especialidade.Especialidade;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import com.romeuzxg.clinica_medica.especialidade.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final EspecialidadeRepository especialidadeRepository;

    public List<MedicoResponse> findAll() {
        return medicoRepository.findAll().stream()
                .map(MedicoMapper::toDTO)
                .toList();
    }

    public MedicoResponse findById(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        return MedicoMapper.toDTO(medico);
    }

    public MedicoResponse save(MedicoRequest medicoRequest) {
        Especialidade especialidade = especialidadeRepository.findById(medicoRequest.especialidadeId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Medico entity = medicoRepository.save(MedicoMapper.toEntity(medicoRequest, especialidade));
        return MedicoMapper.toDTO(entity);
    }

    public MedicoResponse updateById(Long id, MedicoRequest medicoRequest) {
        Especialidade especialidade = especialidadeRepository.findById(medicoRequest.especialidadeId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Medico entity = MedicoMapper.toEntity(medicoRequest, especialidade);
        entity.setId(id);
        Medico save = medicoRepository.save(entity);
        return MedicoMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }

}
