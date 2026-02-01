package com.example.Gestion.de.Citas.presentation.controller;

import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteUpdateDto;
import com.example.Gestion.de.Citas.service.interfaces.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteResponseDto> listaDeClientes(){
        return clienteService.listaDeClientes();
    }

    @GetMapping("/{id}")
    public ClienteResponseDto obtenerClientePorID(@PathVariable Long id){
        return clienteService.obtenerClientePorID(id);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> crearNuevoCliente(@Valid @RequestBody ClienteRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.crearNuevoCliente(dto));
    }

    @PutMapping("/{id}")
    public ClienteResponseDto actualizarCliente(@RequestBody ClienteUpdateDto dto, @PathVariable Long id){
        return clienteService.actualizarCliente(dto,id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
    }
}
