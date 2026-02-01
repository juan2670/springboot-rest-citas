package com.example.Gestion.de.Citas.service.implementations;

import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteRequestDto;
import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteResponseDto;
import com.example.Gestion.de.Citas.presentation.dto.cliente.ClienteUpdateDto;
import com.example.Gestion.de.Citas.persistence.entity.Cliente;
import com.example.Gestion.de.Citas.util.mapper.ClienteMapper;
import com.example.Gestion.de.Citas.persistence.repository.ClienteRepository;
import com.example.Gestion.de.Citas.service.interfaces.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public List<ClienteResponseDto> listaDeClientes() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::clienteToClienteResponseDto)
                .toList();
    }

    public ClienteResponseDto obtenerClientePorID(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::clienteToClienteResponseDto)
                .orElseThrow( () -> new RuntimeException("Cliente no encontrada con ID: " + id));
    }

    public ClienteResponseDto crearNuevoCliente(ClienteRequestDto dto) {
        Cliente nuevoCliente = clienteMapper.clienteRequestDtoToEntity(dto);
        Cliente clienteGuardado = clienteRepository.save(nuevoCliente);
        return clienteMapper.clienteToClienteResponseDto(clienteGuardado);
    }

    public ClienteResponseDto actualizarCliente(ClienteUpdateDto dto, Long id) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente no encontrado con el ID: " + id));
        clienteMapper.clienteUpdateDto(dto, clienteExistente);
        return clienteMapper.clienteToClienteResponseDto(clienteRepository.save(clienteExistente));
    }

    public void eliminarCliente(Long id) {
        if(!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
