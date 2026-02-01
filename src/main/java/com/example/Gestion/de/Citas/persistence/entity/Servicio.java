package com.example.Gestion.de.Citas.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private Integer duracion;

    @Column(nullable = false)
    private Double precio;

    @OneToMany(mappedBy = "servicio", fetch = FetchType.LAZY)
    private List<Cita> cita;

}
