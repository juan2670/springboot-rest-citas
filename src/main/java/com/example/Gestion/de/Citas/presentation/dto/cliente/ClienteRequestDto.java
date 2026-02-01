package com.example.Gestion.de.Citas.presentation.dto.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteRequestDto(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 3,message = "El nombre debe tener al menos 3 letras")
        @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El nombre solo puede contener letras")
        String nombre,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El formato del email es inválido (ej: usuario@dominio.com)")
        String email,

        @NotBlank(message = "El teléfono es obligatorio")
        @Pattern(regexp = "^[0-9]+$", message = "El teléfono solo puede contener números")
        String telefono
){}
