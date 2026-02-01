package com.example.Gestion.de.Citas.util.mapper;

import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioUpdateDto;
import com.example.Gestion.de.Citas.persistence.entity.Servicio;
import org.mapstruct.*;

@Mapper(componentModel =  MappingConstants.ComponentModel.SPRING)
public interface ServicioMapper {

    // Cliente -> DTO
    ServicioResponseDto servicioToServicioResponseDto(Servicio servicio);

    // DTO -> cliente
    Servicio ServicioRequestDtoToServicio(ServicioRequestDto servicioRequestDto);

    //DTO -> cliente
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void servicioUpdateDto(ServicioUpdateDto servicioUpdateDto, @MappingTarget Servicio servicio);

}
