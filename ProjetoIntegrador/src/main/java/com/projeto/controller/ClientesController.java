package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.entities.Clientes;
import com.projeto.services.ClientesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Clientes", description = "API REST DE GERENCIAMENTO DE CLIENTES")
@RestController
@RequestMapping("/clientes")
@CrossOrigin (origins= "*")
public class ClientesController {
    
    private final ClientesService clientesService;
    
    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localiza Cliente por ID")
    public ResponseEntity<Clientes> getProductById(@PathVariable Long id) {
    	Clientes clientes = clientesService.getClientesById(id);
        if (clientes != null) {
            return ResponseEntity.ok(clientes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Apresenta todos os Clientes")
    public ResponseEntity<List<Clientes>> getAllClientess() {
        List<Clientes> clientess = clientesService.getAllClientess();
        return ResponseEntity.ok(clientess);
    }
    @PostMapping
    @Operation(summary = "Cadastra um Clientes")
    public ResponseEntity<Clientes> criarClientes(@RequestBody @Valid Clientes clientes) {
    	Clientes criarClientes= clientesService.salvarClientes(clientes);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarClientes);
    }
   

    @PutMapping("/{id}")
    @Operation(summary = "Altera o Cliente")
    public ResponseEntity<Clientes> updateClientes(@PathVariable Long id, @RequestBody @Valid Clientes clientes) {
    	Clientes updatedClientes = clientesService.updateClientes(id, clientes);
        if (updatedClientes != null) {
            return ResponseEntity.ok(updatedClientes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o Cliente")
    public ResponseEntity<String> deleteClientes(@PathVariable Long id) {
        boolean deleted = clientesService.deleteClientes(id);
        if (deleted) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}