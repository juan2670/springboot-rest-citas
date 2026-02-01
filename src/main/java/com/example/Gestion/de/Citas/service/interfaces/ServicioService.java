package com.example.Gestion.de.Citas.service.interfaces;

import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioUpdateDto;

import java.util.List;

public interface ServicioService {

    //Get
    List<ServicioResponseDto> listaDeServicios();

    //Get by id
    ServicioResponseDto obtenerServicioID(Long id);

    //Post
    ServicioResponseDto crearNuevoServicio(ServicioRequestDto dto);

    //Put
    ServicioResponseDto actualizarServicio(ServicioUpdateDto dto, Long id);

    //Delete
    void eliminarServicio(Long id);

}
