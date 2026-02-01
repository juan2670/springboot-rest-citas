package com.example.Gestion.de.Citas.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "citas")
public class Cita{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Column(nullable = false)
    private String profesional;

    @Column(nullable = false, name = "fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @Column(nullable = false, name="fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    @Column(nullable = false)
    private Boolean estado;

}
