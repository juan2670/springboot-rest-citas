package com.example.Gestion.de.Citas.presentation.dto.cita;

import java.time.LocalDateTime;

public record CitaResponseDto(
        Long idCita,
        String nombreCliente,
        String nombreServicio,
        String profesional,
        LocalDateTime fechaHoraInicio,
        LocalDateTime fechaHoraFin,
        Integer duracion,
        Boolean estado
) {}
