package com.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.entities.Clientes;
import com.projeto.repository.ClientesRepository;

@Service
public class ClientesService {
    private final ClientesRepository clientesRepository;
    
    @Autowired
    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public List<Clientes> getAllClientess() {
        return clientesRepository.findAll();
    }

    public Clientes getClientesById(Long id) {
        Optional<Clientes> clientes = clientesRepository.findById(id);
        return clientes.orElse(null);
    }

    public Clientes salvarClientes(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    public Clientes updateClientes(Long id, Clientes updatedClientes) {
        Optional<Clientes> existingClientes = clientesRepository.findById(id);
        if (existingClientes.isPresent()) {
            updatedClientes.setId(id);
            return clientesRepository.save(updatedClientes);
        }
        return null;
    }
    public boolean deleteClientes(Long id) {
        Optional<Clientes> existingClientes = clientesRepository.findById(id);
        if (existingClientes.isPresent()) {
        	clientesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}