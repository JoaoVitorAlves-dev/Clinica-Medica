package com.romeuzxg.clinica_medica.convenio;

import com.romeuzxg.clinica_medica.convenio.dto.ConvenioRequest;
import com.romeuzxg.clinica_medica.convenio.dto.ConvenioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/convenios")
@RequiredArgsConstructor
public class ConvenioController {

    private final ConvenioService convenioService;

    @GetMapping
    public ResponseEntity<List<ConvenioResponse>> findAll() {
        return ResponseEntity.ok(convenioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvenioResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(convenioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ConvenioResponse> save(@RequestBody ConvenioRequest convenioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(convenioService.save(convenioRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConvenioResponse> updateById(@PathVariable Long id, @RequestBody ConvenioRequest convenioRequest) {
        return ResponseEntity.ok(convenioService.updateById(id, convenioRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        convenioService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
