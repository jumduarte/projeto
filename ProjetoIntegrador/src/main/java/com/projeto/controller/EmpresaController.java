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

import com.projeto.entities.Empresa;
import com.projeto.services.EmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Empresas", description = "API REST DE GERENCIAMENTO DE EMPRESAS")
@RestController
@RequestMapping("/empresas")
@CrossOrigin (origins= "*")
public class EmpresaController {
    
    private final EmpresaService empresaService;
    
    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localiza Empresa por ID")
    public ResponseEntity<Empresa> getProductById(@PathVariable Long id) {
    	Empresa empresas = empresaService.getEmpresaById(id);
        if (empresas != null) {
            return ResponseEntity.ok(empresas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Apresenta todos as Empresas")
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> empresas = empresaService.getAllEmpresas();
        return ResponseEntity.ok(empresas);
    }
    @PostMapping
    @Operation(summary = "Cadastra uma Empresa")
    public ResponseEntity<Empresa> criarEmpresa(@RequestBody @Valid Empresa empresa) {
    	Empresa criarEmpresa= empresaService.salvarEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarEmpresa);
    }
   

    @PutMapping("/{id}")
    @Operation(summary = "Altera a Empresa")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody @Valid Empresa empresa) {
    	Empresa updatedEmpresa = empresaService.updateEmpresa(id, empresa);
        if (updatedEmpresa != null) {
            return ResponseEntity.ok(updatedEmpresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta a Empresa")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id) {
        boolean deleted = empresaService.deleteEmpresa(id);
        if (deleted) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}