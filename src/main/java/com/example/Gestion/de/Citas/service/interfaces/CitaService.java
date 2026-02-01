package com.example.Gestion.de.Citas.service.interfaces;

import com.example.Gestion.de.Citas.presentation.dto.cita.CitaRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.cita.CitaResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.cita.CitaUpdateDto;

import java.util.List;

public interface CitaService {

    List<CitaResponseDto> obtenerListaDeCitas();

    CitaResponseDto consultarCitaPorId(Long id);

    CitaResponseDto crearNuevaCita(CitaRequestDto request);

    CitaResponseDto actualizarCita(CitaUpdateDto dto, Long id);

    void eliminarCita(Long id);

}
