package com.github.vitorzottino.ms_proposta_credito.controller;


import com.github.vitorzottino.ms_proposta_credito.dto.FormDataDTO;
import com.github.vitorzottino.ms_proposta_credito.dto.PropostaDTO;
import com.github.vitorzottino.ms_proposta_credito.dto.PropostaUpdateDTO;
import com.github.vitorzottino.ms_proposta_credito.service.PropostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("propostas")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @GetMapping
    public ResponseEntity<Page<PropostaDTO>> findAll(
            @PageableDefault(size = 10) Pageable pageable) {
        Page<PropostaDTO> propostas = propostaService.findAll(pageable);
        return ResponseEntity.ok(propostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaDTO> findById(@PathVariable Long id) {
        PropostaDTO propostaDTO = propostaService.findById(id);
        return ResponseEntity.ok(propostaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropostaUpdateDTO> update(@PathVariable Long id, @RequestBody @Valid PropostaUpdateDTO propostaDTO) {
        propostaDTO = propostaService.update(id, propostaDTO);
        return ResponseEntity.ok(propostaDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        propostaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<FormDataDTO> insert(@RequestBody @Valid FormDataDTO dto) {
        dto = propostaService.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto)
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

}
