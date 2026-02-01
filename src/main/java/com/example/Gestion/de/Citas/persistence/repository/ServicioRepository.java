package com.example.Gestion.de.Citas.persistence.repository;

import com.example.Gestion.de.Citas.persistence.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Long> {}
