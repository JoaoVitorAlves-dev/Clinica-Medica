package com.romeuzxg.clinica_medica.service;

import com.romeuzxg.clinica_medica.dto.request.PacienteRequest;
import com.romeuzxg.clinica_medica.dto.response.PacienteResponse;
import com.romeuzxg.clinica_medica.entity.Paciente;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import com.romeuzxg.clinica_medica.mapper.PacienteMapper;
import com.romeuzxg.clinica_medica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public List<PacienteResponse> findAll() {
        return pacienteRepository.findAll().stream()
                .map(PacienteMapper::toDTO)
                .toList();
    }

    public PacienteResponse findById(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        return PacienteMapper.toDTO(paciente);
    }

    public PacienteResponse save(PacienteRequest pacienteRequest) {
        Paciente entity = PacienteMapper.toEntity(pacienteRequest);
        Paciente save = pacienteRepository.save(entity);
        return PacienteMapper.toDTO(save);
    }

    public PacienteResponse updateById(Long id, PacienteRequest pacienteRequest) {
        pacienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Paciente entity = PacienteMapper.toEntity(pacienteRequest);
        entity.setId(id);
        Paciente save = pacienteRepository.save(entity);
        return PacienteMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

}
