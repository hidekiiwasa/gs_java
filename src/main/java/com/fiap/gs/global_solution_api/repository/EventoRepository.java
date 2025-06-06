package com.fiap.gs.global_solution_api.repository;

import com.fiap.gs.global_solution_api.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findAllByEstado(String estado);
    @Query("SELECT e FROM Evento e WHERE e.estado = :estado AND e.regiao = :regiao")
    List<Evento> findByRegiaoDeEstado(@Param("estado") String estado, @Param("regiao") String regiao);


}
