package com.example.Gestion.de.Citas.persistence.repository;

import com.example.Gestion.de.Citas.persistence.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita,Long> {}
