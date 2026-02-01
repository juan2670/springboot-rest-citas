package com.example.Gestion.de.Citas.presentation.controller;

import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.servicios.ServicioUpdateDto;
import com.example.Gestion.de.Citas.service.interfaces.ServicioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioService servicioService;

    @GetMapping
    public List<ServicioResponseDto> listaDeServicios(){
        return servicioService.listaDeServicios();
    }

    @GetMapping("/{id}")
    public ServicioResponseDto obtenerServicioID(@PathVariable Long id){
        return servicioService.obtenerServicioID(id);
    }

    @PostMapping
    public ResponseEntity<ServicioResponseDto> crearNuevoServicio(@Valid @RequestBody ServicioRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioService.crearNuevoServicio(dto));
    }

    @PutMapping("/{id}")
    public ServicioResponseDto actualizarServicio(@RequestBody ServicioUpdateDto dto, @PathVariable Long id){
        return servicioService.actualizarServicio(dto,id);
    }

    @DeleteMapping("/{id}")
    public void eliminarServicio(@PathVariable Long id){
        servicioService.eliminarServicio(id);
    }
}
