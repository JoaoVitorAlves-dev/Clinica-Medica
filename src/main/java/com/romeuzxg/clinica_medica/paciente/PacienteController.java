package com.romeuzxg.clinica_medica.paciente;

import com.romeuzxg.clinica_medica.paciente.dto.PacienteRequest;
import com.romeuzxg.clinica_medica.paciente.dto.PacienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> findAll() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PacienteResponse> save(@RequestBody PacienteRequest pacienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(pacienteRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> updateById(@PathVariable Long id, @RequestBody PacienteRequest pacienteRequest) {
        return ResponseEntity.ok(pacienteService.updateById(id, pacienteRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pacienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
