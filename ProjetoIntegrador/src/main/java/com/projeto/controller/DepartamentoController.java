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

import com.projeto.entities.Departamento;
import com.projeto.services.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Departamentos", description = "API REST DE GERENCIAMENTO DE DEPARTAMENTOS")
@RestController
@RequestMapping("/departamentos")
@CrossOrigin (origins= "*")
public class DepartamentoController {
    
    private final DepartamentoService departamentoService;
    
    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localiza Departamento por ID")
    public ResponseEntity<Departamento> getProductById(@PathVariable Long id) {
    	Departamento departamentos = departamentoService.getDepartamentoById(id);
        if (departamentos != null) {
            return ResponseEntity.ok(departamentos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Apresenta todos as Departamentos")
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        List<Departamento> departamentos = departamentoService.getAllDepartamentos();
        return ResponseEntity.ok(departamentos);
    }
    @PostMapping
    @Operation(summary = "Cadastra uma Departamento")
    public ResponseEntity<Departamento> criarDepartamento(@RequestBody @Valid Departamento departamento) {
    	Departamento criarDepartamento= departamentoService.salvarDepartamento(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarDepartamento);
    }
   

    @PutMapping("/{id}")
    @Operation(summary = "Altera a Departamento")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody @Valid Departamento departamento) {
    	Departamento updatedDepartamento = departamentoService.updateDepartamento(id, departamento);
        if (updatedDepartamento != null) {
            return ResponseEntity.ok(updatedDepartamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o Departamento")
    public ResponseEntity<String> deleteDepartamento(@PathVariable Long id) {
        boolean deleted = departamentoService.deleteDepartamento(id);
        if (deleted) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}