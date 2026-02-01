package com.example.Gestion.de.Citas.service.interfaces;

import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteUpdateDto;

import java.util.List;

public interface ClienteService {

    //Get
    List<ClienteResponseDto> listaDeClientes();

    //Get by id
    ClienteResponseDto obtenerClientePorID(Long id);

    //Post
    ClienteResponseDto crearNuevoCliente(ClienteRequestDto dto);

    //Put
    ClienteResponseDto actualizarCliente(ClienteUpdateDto dto, Long id);

    //Delete
    void eliminarCliente(Long id);



}
