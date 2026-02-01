package com.example.Gestion.de.Citas.service.implementations;

import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioUpdateDto;
import com.example.Gestion.de.Citas.persistence.entity.Servicio;
import com.example.Gestion.de.Citas.util.mapper.ServicioMapper;
import com.example.Gestion.de.Citas.persistence.repository.ServicioRepository;
import com.example.Gestion.de.Citas.service.interfaces.ServicioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;
    private final ServicioMapper servicioMapper;


    public List<ServicioResponseDto> listaDeServicios() {
        return servicioRepository.findAll().stream()
                .map(servicioMapper::servicioToServicioResponseDto)
                .toList();
    }


    public ServicioResponseDto obtenerServicioID(Long id) {
        return servicioRepository.findById(id)
                .map(servicioMapper::servicioToServicioResponseDto)
                .orElseThrow(()-> new RuntimeException("Cliente no encontrado con el ID: " + id));
    }

    public ServicioResponseDto crearNuevoServicio(ServicioRequestDto dto) {
        Servicio nuevoServicio = servicioMapper.ServicioRequestDtoToServicio(dto);
        Servicio servicioCreado = servicioRepository.save(nuevoServicio);
        return servicioMapper.servicioToServicioResponseDto(servicioCreado);
    }


    public ServicioResponseDto actualizarServicio(ServicioUpdateDto dto, Long id) {
        Servicio servicioExistente = servicioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Servicio no encontrado con el ID: " + id));

        servicioMapper.servicioUpdateDto(dto,servicioExistente);
        return servicioMapper.servicioToServicioResponseDto(servicioRepository.save(servicioExistente));
    }

    public void eliminarServicio(Long id) {
        if(!servicioRepository.existsById(id)){
            throw new RuntimeException("Servicio no encontrado con el ID: " + id);
        }
        servicioRepository.deleteById(id);
    }
}
