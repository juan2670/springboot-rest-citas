package com.example.Gestion.de.Citas.util.mapper;

import com.example.Gestion.de.Citas.presentation.dto.cita.CitaRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.cita.CitaResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.cita.CitaUpdateDto;
import com.example.Gestion.de.Citas.persistence.entity.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel =  MappingConstants.ComponentModel.SPRING)
public interface CitaMapper {

    // Entity -> Response (Para GET)
    @Mapping(source = "id", target = "idCita")
    @Mapping(source = "cliente.nombre", target = "nombreCliente")
    @Mapping(source = "servicio.nombre", target = "nombreServicio")
    @Mapping(source = "servicio.duracion", target = "duracion")
    CitaResponseDto toResponseDto(Cita cita);

    // Request -> Entity (Para POST)
    @Mapping(source = "clienteId", target = "cliente.id")
    @Mapping(source = "servicioId", target = "servicio.id")
    Cita toEntity(CitaRequestDto requestDto);

    // Update -> Entity (Para PUT)
    @Mapping(source = "idCita", target = "id")
    @Mapping(source = "clienteId", target = "cliente.id")
    @Mapping(source = "servicioId", target = "servicio.id")
    void updateEntityFromDto(CitaUpdateDto updateDto, @MappingTarget Cita entity);
}
