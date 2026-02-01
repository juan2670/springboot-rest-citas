package com.example.Gestion.de.Citas.service.implementations;

import com.example.Gestion.de.Citas.presentation.dto.cita.CitaRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.cita.CitaResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.cita.CitaUpdateDto;
import com.example.Gestion.de.Citas.persistence.entity.Cita;
import com.example.Gestion.de.Citas.persistence.entity.Cliente;
import com.example.Gestion.de.Citas.persistence.entity.Servicio;
import com.example.Gestion.de.Citas.service.exception.RecursoNoEncontradoException;
import com.example.Gestion.de.Citas.util.mapper.CitaMapper;
import com.example.Gestion.de.Citas.persistence.repository.CitaRepository;
import com.example.Gestion.de.Citas.persistence.repository.ClienteRepository;
import com.example.Gestion.de.Citas.persistence.repository.ServicioRepository;
import com.example.Gestion.de.Citas.service.interfaces.CitaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final ClienteRepository clienteRepository;
    private final ServicioRepository servicioRepository;
    private final CitaMapper citaMapper;

    // --- LISTAR ---
    public List<CitaResponseDto> obtenerListaDeCitas(){
            return citaRepository.findAll().stream()
                .map(citaMapper::toResponseDto)
                .toList();
    }

    public CitaResponseDto consultarCitaPorId(Long id) {
        return citaRepository.findById(id)
                .map(citaMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + id));
    }

    public CitaResponseDto crearNuevaCita(CitaRequestDto request){

        if(request.fechaHoraFin().isBefore(request.fechaHoraInicio())){
            throw new IllegalArgumentException("La fecha de fin no puede ser antes de la fecha de inicio");
        }

        Cita citaNueva = citaMapper.toEntity(request);

        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow( () -> new RecursoNoEncontradoException("Cliente no encontrado con el ID " + request.clienteId()));

        Servicio servicio = servicioRepository.findById(request.servicioId())
                .orElseThrow( () -> new RecursoNoEncontradoException("Servicio no encontrado con el ID " + request.servicioId()));

        citaNueva.setCliente(cliente);
        citaNueva.setServicio(servicio);

        Cita citaGuardada = citaRepository.save(citaNueva);
        return citaMapper.toResponseDto(citaGuardada);
    }

    public CitaResponseDto actualizarCita(CitaUpdateDto dto, Long id) {
        Cita citaExistente = citaRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Cita no existe con el ID " + id));

        //
        citaMapper.updateEntityFromDto(dto, citaExistente);

        //
        if(dto.clienteId() != null){
            Cliente nuevoCliente = clienteRepository.findById(dto.clienteId())
                    .orElseThrow( () -> new RuntimeException("Cliente no existe"));
            citaExistente.setCliente(nuevoCliente);
        }

        //
        if(dto.servicioId() != null){
            Servicio nuevoServicio = servicioRepository.findById(dto.servicioId())
                    .orElseThrow( () -> new RuntimeException("Servicio no existe"));

            citaExistente.setServicio(nuevoServicio);
        }

        return citaMapper.toResponseDto(citaRepository.save(citaExistente));
    }

    public void eliminarCita(Long id){
        if(!citaRepository.existsById(id)){
            throw new RuntimeException("Cita no encontrada");
        }
        citaRepository.deleteById(id);
    }
}
