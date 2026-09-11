package com.romeuzxg.clinica_medica.especialidade;

import com.romeuzxg.clinica_medica.especialidade.dto.EspecialidadeRequest;
import com.romeuzxg.clinica_medica.especialidade.dto.EspecialidadeResponse;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    public List<EspecialidadeResponse> findAll() {
        return especialidadeRepository.findAll().stream()
                .map(EspecialidadeMapper::toDTO)
                .toList();
    }

    public EspecialidadeResponse findById(Long id) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        return EspecialidadeMapper.toDTO(especialidade);
    }

    public EspecialidadeResponse findByEspecialidade(EspecialidadeRequest especialidade) {
        Especialidade byEspecialidade = especialidadeRepository.findByEspecialidade(EspecialidadeMapper.toEntity(especialidade));
        return EspecialidadeMapper.toDTO(byEspecialidade);
    }

    public EspecialidadeResponse save(EspecialidadeRequest especialidadeRequest) {
        Especialidade save = especialidadeRepository.save(EspecialidadeMapper.toEntity(especialidadeRequest));
        return EspecialidadeMapper.toDTO(save);
    }

    public EspecialidadeResponse updateById(Long id, EspecialidadeRequest especialidadeRequest) {
        especialidadeRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Especialidade entity = EspecialidadeMapper.toEntity(especialidadeRequest);
        entity.setId(id);
        Especialidade save = especialidadeRepository.save(entity);
        return EspecialidadeMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        especialidadeRepository.deleteById(id);
    }

}
