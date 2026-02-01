package com.example.Gestion.de.Citas.presentation.dto.cliente;

public record ClienteUpdateDto(
        Long id,
        String nombre,
        String email,
        String telefono
){}
