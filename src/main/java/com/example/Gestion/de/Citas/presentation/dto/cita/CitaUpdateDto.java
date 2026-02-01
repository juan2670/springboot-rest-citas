package com.example.Gestion.de.Citas.presentation.dto.cita;

import java.time.LocalDateTime;

public record CitaUpdateDto(
        Long idCita,
        Long clienteId,
        Long servicioId,
        String profesional,
        LocalDateTime fechaHoraInicio,
        Boolean estado
) {}
