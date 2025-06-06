package com.fiap.gs.global_solution_api.service;

import com.fiap.gs.global_solution_api.dto.EventoRequestCreate;
import com.fiap.gs.global_solution_api.dto.EventoRequestUpdate;
import com.fiap.gs.global_solution_api.enums.StatusEvento;
import com.fiap.gs.global_solution_api.model.Endereco;
import com.fiap.gs.global_solution_api.model.Evento;
import com.fiap.gs.global_solution_api.repository.EventoRepository;
import com.fiap.gs.global_solution_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Evento saveEvento(EventoRequestCreate dto) {
        Evento evento = new Evento();
        var usuario = usuarioRepository.findById(dto.getIdUsuario());

        if (usuario.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado com id: " + dto.getIdUsuario());
        }

        evento.setUsuario(usuario.get());
        evento.setEndereco(new Endereco().stringificarEndereco(dto.getEndereco()));
        evento.setCep(dto.getCep());
        evento.setRegiao(dto.getRegiao());
        evento.setEstado(dto.getEstado());
        evento.setCausa(dto.getCausa());
        evento.setDescricao(dto.getDescricao());
        evento.setStatus(StatusEvento.OCORRENDO);
        evento.setQuandoComecou(LocalDateTime.now());

        return eventoRepository.save(evento);
    }

    public List<Evento> findAllByEstado(String estado) {
        return eventoRepository.findAllByEstado(estado);
    }

    public List<Evento> findAllByRegiaoDeEstado(String estado, String regiao) {
        return eventoRepository.findByRegiaoDeEstado(estado, regiao);
    }

    public List<Evento> findAllEventos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> findById(Long id) {
        return eventoRepository.findById(id);
    }

    public Optional<Evento> update(Long id, EventoRequestUpdate dto) {
        return eventoRepository.findById(id)
                .map(evento -> {
                    evento.setEndereco(new Endereco().stringificarEndereco(dto.getEndereco()));
                    evento.setCep(dto.getCep());
                    evento.setRegiao(dto.getRegiao());
                    evento.setEstado(dto.getEstado());
                    evento.setCausa(dto.getCausa());
                    evento.setDescricao(dto.getDescricao());
                    evento.setStatus(dto.getStatus());
                    return eventoRepository.save(evento);
                });
    }

    public boolean deleteById(Long id) {
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            return true;
        }

        return false;
    }


}
