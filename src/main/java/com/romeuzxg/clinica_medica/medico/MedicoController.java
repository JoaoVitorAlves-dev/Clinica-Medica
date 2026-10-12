package com.romeuzxg.clinica_medica.medico;

import com.romeuzxg.clinica_medica.medico.dto.MedicoRequest;
import com.romeuzxg.clinica_medica.medico.dto.MedicoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping("/listar")
    public ResponseEntity<Page<MedicoResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(medicoService.findAll(pageable));
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<MedicoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.findById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<MedicoResponse> save(@RequestBody @Valid MedicoRequest medicoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(medicoRequest));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<MedicoResponse> updateById(@PathVariable Long id, @RequestBody @Valid MedicoRequest medicoRequest) {
        return ResponseEntity.ok(medicoService.updateById(id, medicoRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        medicoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
