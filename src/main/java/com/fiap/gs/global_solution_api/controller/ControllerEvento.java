package com.fiap.gs.global_solution_api.controller;

import com.fiap.gs.global_solution_api.dto.EventoRequestCreate;
import com.fiap.gs.global_solution_api.dto.EventoRequestGet;
import com.fiap.gs.global_solution_api.dto.EventoRequestUpdate;
import com.fiap.gs.global_solution_api.dto.EventoResponse;
import com.fiap.gs.global_solution_api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("eventos")
public class ControllerEvento {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoResponse> criarEvento(@RequestBody EventoRequestCreate dto) {
        return ResponseEntity.status(201).body(new EventoResponse().toDto(eventoService.saveEvento(dto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<EventoResponse> update(@PathVariable Long id, @RequestBody EventoRequestUpdate dto) {
        return eventoService.update(id, dto)
                .map(evento -> {
                    return ResponseEntity.status(200).body(new EventoResponse().toDto(evento));
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EventoRequestGet>> findAll() {
        return ResponseEntity.ok(eventoService.findAllEventos().stream()
                .map(evento -> {
                    return new EventoRequestGet().toDto(evento);
                }).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<EventoRequestGet> findById(@PathVariable Long id) {
        return eventoService.findById(id)
                .map(evento -> {
                    return ResponseEntity.status(200).body(new EventoRequestGet().toDto(evento));
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado")
    public ResponseEntity<List<EventoRequestGet>> findByEstado(@RequestParam String estado) {
        return ResponseEntity.ok(eventoService.findAllByEstado(estado).stream()
                .map(evento -> {
                    return new EventoRequestGet().toDto(evento);
                }).collect(Collectors.toList()));
    }

    @GetMapping("/regiaoestado")
    public ResponseEntity<List<EventoRequestGet>> findAllByRegiaoDeEstado(@RequestParam String estado, @RequestParam String regiao) {
        return ResponseEntity.ok(eventoService.findAllByRegiaoDeEstado(estado, regiao).stream()
                .map(evento -> {
                    return new EventoRequestGet().toDto(evento);
                }).collect(Collectors.toList()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean result = eventoService.deleteById(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}