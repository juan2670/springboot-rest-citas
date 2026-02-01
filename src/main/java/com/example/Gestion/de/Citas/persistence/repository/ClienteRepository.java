package com.example.Gestion.de.Citas.persistence.repository;

import com.example.Gestion.de.Citas.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> { }
