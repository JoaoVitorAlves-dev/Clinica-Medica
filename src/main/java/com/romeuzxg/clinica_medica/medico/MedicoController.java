package com.romeuzxg.clinica_medica.medico;

import com.romeuzxg.clinica_medica.medico.dto.MedicoRequest;
import com.romeuzxg.clinica_medica.medico.dto.MedicoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoResponse>> findAll() {
        return ResponseEntity.ok(medicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MedicoResponse> save(@RequestBody @Valid MedicoRequest medicoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(medicoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponse> updateById(@PathVariable Long id, @RequestBody @Valid MedicoRequest medicoRequest) {
        return ResponseEntity.ok(medicoService.updateById(id, medicoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        medicoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
