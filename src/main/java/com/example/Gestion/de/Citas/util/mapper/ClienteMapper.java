package com.example.Gestion.de.Citas.util.mapper;

import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteUpdateDto;
import com.example.Gestion.de.Citas.persistence.entity.Cliente;
import org.mapstruct.*;

@Mapper(componentModel =  MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {

    // Entity -> Response (Para GET)
    ClienteResponseDto clienteToClienteResponseDto(Cliente cliente);

    // Request -> Entity (Para post)
    Cliente clienteRequestDtoToEntity(ClienteRequestDto clienteRequestDto );

    //  Update -> Entity (Para Put)
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void clienteUpdateDto(ClienteUpdateDto clienteUpdateDto,@MappingTarget Cliente entity);

}
