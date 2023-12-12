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

import com.projeto.entities.Projeto;
import com.projeto.services.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

	@Tag(name = "Projetos", description = "API REST DE GERENCIAMENTO DE PROJETOS")
	@RestController
	@RequestMapping("/projetos")
	@CrossOrigin (origins= "*")
	public class ProjetoController {
	    
	    private final ProjetoService projetoService;
	    
	    @Autowired
	    public ProjetoController(ProjetoService projetoService) {
	        this.projetoService = projetoService;
	    }

	    @GetMapping("/{id}")
	    @Operation(summary = "Localiza projeto por ID")
	    public ResponseEntity<Projeto> getProductById(@PathVariable Long id) {
	    	Projeto projeto = projetoService.getProjetoById(id);
	        if (projeto != null) {
	            return ResponseEntity.ok(projeto);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping
	    @Operation(summary = "Apresenta todos os projetos")
	    public ResponseEntity<List<Projeto>> getAllProjetos() {
	        List<Projeto> projetos = projetoService.getAllProjetos();
	        return ResponseEntity.ok(projetos);
	    }
	    @PostMapping
	    @Operation(summary = "Cadastra um projeto")
	    public ResponseEntity<Projeto> criarProjeto(@RequestBody @Valid Projeto projeto) {
	    	Projeto criarProjeto = projetoService.salvarProjeto(projeto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(criarProjeto);
	    }
	   

	    @PutMapping("/{id}")
	    @Operation(summary = "Altera o projeto")
	    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody @Valid Projeto projeto) {
	    	Projeto updatedProjeto = projetoService.updateProjeto(id, projeto);
	        if (updatedProjeto != null) {
	            return ResponseEntity.ok(updatedProjeto);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    @Operation(summary = "Deleta o projeto")
	    public ResponseEntity<String> deleteProjeto(@PathVariable Long id) {
	        boolean deleted = projetoService.deleteProjeto(id);
	        if (deleted) {
	        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}