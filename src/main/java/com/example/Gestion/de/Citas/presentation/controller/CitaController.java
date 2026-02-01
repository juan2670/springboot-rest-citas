package com.example.Gestion.de.Citas.presentation.controller;

import com.example.Gestion.de.Citas.presentation.dto.cita.CitaRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.cita.CitaResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.cita.CitaUpdateDto;
import com.example.Gestion.de.Citas.service.interfaces.CitaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    @GetMapping
    public List<CitaResponseDto> listarCitas(){
        return citaService.obtenerListaDeCitas();
    }

    @GetMapping("/{id}")
    public CitaResponseDto consultarCitaPorId(@PathVariable Long id){
        return citaService.consultarCitaPorId(id);
    }

    @PostMapping()
    public ResponseEntity<CitaResponseDto> crearNuevaCita(@Valid @RequestBody CitaRequestDto request){
         return ResponseEntity.status(HttpStatus.CREATED).body( citaService.crearNuevaCita(request));
    }

    @PutMapping("/{id}")
    public CitaResponseDto actualizarCita(@RequestBody CitaUpdateDto dto,@PathVariable Long id){
        return citaService.actualizarCita(dto,id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable Long id){
        citaService.eliminarCita(id);
    }

}
