package com.romeuzxg.clinica_medica.convenio;

import com.romeuzxg.clinica_medica.convenio.dto.request.ConvenioRequest;
import com.romeuzxg.clinica_medica.convenio.dto.response.ConvenioResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convenios")
@RequiredArgsConstructor
public class ConvenioController {

    private final ConvenioService convenioService;

    @GetMapping("/listar")
    public ResponseEntity<Page<ConvenioResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(convenioService.findAll(pageable));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ConvenioResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(convenioService.findById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ConvenioResponse> save(@RequestBody @Valid ConvenioRequest convenioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(convenioService.save(convenioRequest));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ConvenioResponse> updateById(@PathVariable Long id, @RequestBody @Valid ConvenioRequest convenioRequest) {
        return ResponseEntity.ok(convenioService.updateById(id, convenioRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        convenioService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
