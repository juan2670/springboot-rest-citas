package com.example.Gestion.de.Citas.presentation.dto.cliente;

public record ClienteResponseDto(
        Long id,
        String nombre,
        String telefono,
        String email
){}
