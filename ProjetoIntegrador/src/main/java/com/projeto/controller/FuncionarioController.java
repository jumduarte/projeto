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

import com.projeto.entities.Funcionario;
import com.projeto.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/funcionarios")
@Tag (name = "Funcionario", description = "API REST DE GERENCIAMENTO DE FUNCIONARIOS")
@CrossOrigin (origins= "*")
public class FuncionarioController {
private final FuncionarioService funcionarioService;

@Autowired

public FuncionarioController(FuncionarioService funcionarioService) {
	this.funcionarioService = funcionarioService;
}
@GetMapping("/{id}")
@Operation(summary = "localiza funcionario por id")
public ResponseEntity<Funcionario> getProductById(@PathVariable Long id) {
	Funcionario funcionario = funcionarioService.getFuncionarioById(id);
	if (funcionario != null) {
		return ResponseEntity.ok(funcionario);
	} else {
		return ResponseEntity.notFound().build();
	}
}
@GetMapping
@Operation(summary = "apresenta todos os funcionarios")
public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
	List<Funcionario> funcionario = funcionarioService.getAllFuncionarios();
	return ResponseEntity.ok(funcionario);
}
@PostMapping
@Operation(summary = "Cadastra uma Funcionario")
public ResponseEntity<Funcionario> criarFuncionario(@RequestBody @Valid Funcionario funcionario) {
	Funcionario criarFuncionario= funcionarioService.salvarFuncionario(funcionario);
    return ResponseEntity.status(HttpStatus.CREATED).body(criarFuncionario);
}
@PutMapping("/{id}")
@Operation(summary = "alterar o funcionário")
public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
	Funcionario updatedFuncionario = funcionarioService.updateFuncionario(id, funcionario);
	if (updatedFuncionario != null) {

		return ResponseEntity.ok(updatedFuncionario);
	} else {
		return ResponseEntity.notFound().build();
	}
}
@DeleteMapping("/{id}")
@Operation(summary = "deleta funcionario")
public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
	boolean deleted = funcionarioService.deleteFuncionario(id);
	if (deleted) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	} else {
		return ResponseEntity.notFound().build();
	}
}
}