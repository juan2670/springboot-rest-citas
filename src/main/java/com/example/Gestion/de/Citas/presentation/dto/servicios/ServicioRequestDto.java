package com.example.Gestion.de.Citas.presentation.dto.servicios;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ServicioRequestDto(
        @NotBlank(message = "El nombre del servicio es obligatorio")
        @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El nombre solo puede contener letras")
        String nombre,

        @NotNull(message = "El precio es obligatorio")
        @Min(value = 10, message = "El precio mínimo es 10")
        @Digits(integer = 6, fraction = 2, message = "El precio debe tener formato válido (ej: 100.50)")
        @Positive(message = "El precio debe ser mayor a cero")
        BigDecimal precio,

        @NotNull(message = "La duración es obligatoria")
        @Min(value = 15, message = "La duración mínima es de 15 minutos")
        @Positive(message = "La duracion debe ser positiva")
        Integer duracion
) {}
