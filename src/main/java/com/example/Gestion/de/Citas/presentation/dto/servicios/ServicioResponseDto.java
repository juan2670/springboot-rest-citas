package com.example.Gestion.de.Citas.presentation.dto.servicios;

public record ServicioResponseDto(
        Long id,
        String nombre,
        Integer duracion,
        Double precio
) {}
