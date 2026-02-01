package com.example.Gestion.de.Citas.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(unique = true,nullable = false)
    private String email;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Cita> cita;
}
