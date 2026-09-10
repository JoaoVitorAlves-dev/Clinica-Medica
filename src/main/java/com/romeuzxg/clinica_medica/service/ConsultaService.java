package com.romeuzxg.clinica_medica.service;

import com.romeuzxg.clinica_medica.dto.request.ConsultaRequest;
import com.romeuzxg.clinica_medica.dto.response.ConsultaResponse;
import com.romeuzxg.clinica_medica.entity.Consulta;
import com.romeuzxg.clinica_medica.entity.Medico;
import com.romeuzxg.clinica_medica.entity.Paciente;
import com.romeuzxg.clinica_medica.exceptions.IdNotFoundException;
import com.romeuzxg.clinica_medica.mapper.ConsultaMapper;
import com.romeuzxg.clinica_medica.repository.ConsultaRepository;
import com.romeuzxg.clinica_medica.repository.MedicoRepository;
import com.romeuzxg.clinica_medica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public List<ConsultaResponse> findAll() {
        return consultaRepository.findAll().stream()
                .map(ConsultaMapper::toDTO)
                .toList();
    }

    public ConsultaResponse findById(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        return ConsultaMapper.toDTO(consulta);
    }

    public ConsultaResponse save(ConsultaRequest consultaRequest) {
        Paciente paciente = pacienteRepository.findById(consultaRequest.pacienteId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Medico medico = medicoRepository.findById(consultaRequest.medicoId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Consulta save = consultaRepository.save(ConsultaMapper.toEntity(consultaRequest, paciente, medico));
        return ConsultaMapper.toDTO(save);
    }

    public ConsultaResponse updateById(Long id, ConsultaRequest consultaRequest) {
        consultaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Paciente paciente = pacienteRepository.findById(consultaRequest.pacienteId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Medico medico = medicoRepository.findById(consultaRequest.medicoId())
                .orElseThrow(() -> new IdNotFoundException("ID Não existe"));
        Consulta entity = ConsultaMapper.toEntity(consultaRequest, paciente, medico);
        entity.setId(id);
        Consulta save = consultaRepository.save(entity);
        return ConsultaMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

}
