package com.romeuzxg.clinica_medica.paciente;

import com.romeuzxg.clinica_medica.paciente.dto.request.PacienteRequest;
import com.romeuzxg.clinica_medica.paciente.dto.response.PacienteResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping("/listar")
    public ResponseEntity<Page<PacienteResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(pacienteService.findAll(pageable));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<PacienteResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.findById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PacienteResponse> save(@RequestBody @Valid PacienteRequest pacienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(pacienteRequest));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PacienteResponse> updateById(@PathVariable Long id, @RequestBody @Valid PacienteRequest pacienteRequest) {
        return ResponseEntity.ok(pacienteService.updateById(id, pacienteRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pacienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
