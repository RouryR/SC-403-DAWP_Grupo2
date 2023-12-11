package com.SC403_ProyectoWeb.Grupo2.Dao;


import com.SC403_ProyectoWeb.Grupo2.Domain.Tiquetes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiquetesDao extends JpaRepository<Tiquetes, Long> {
    List<Tiquetes> findByUsuarioId(Long usuarioId);
}

