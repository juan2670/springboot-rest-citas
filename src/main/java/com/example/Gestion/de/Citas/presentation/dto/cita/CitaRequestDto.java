package com.example.Gestion.de.Citas.presentation.dto.cita;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record CitaRequestDto(

        @NotNull(message = "El ID del cliente es obligatorio")
        @Positive(message = "El ID del cliente debe ser un número positivo")
        Long clienteId,

        @NotNull(message = "El ID del servicio es obligatorio")
        @Positive(message = "El ID del cliente debe ser un número positivo")
        Long servicioId,

        @NotNull(message = "La fecha de inicio es obligatoria")
        @Future(message = "La cita debe ser en el futuro")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime fechaHoraInicio,

        @NotNull(message = "La fecha de inicio es obligatoria")
        @Future(message = "La cita debe ser en el futuro")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime fechaHoraFin,

        @NotBlank(message = "El nombre es obligatorio")
        @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El nombre solo puede contener letras")
        String profesional,

        @NotNull
        Boolean estado

){}


