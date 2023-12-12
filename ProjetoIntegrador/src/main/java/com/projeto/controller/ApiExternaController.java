package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.entities.Clientes;
import com.projeto.entities.Departamento;
import com.projeto.entities.Empresa;
import com.projeto.entities.Fornecedor;
import com.projeto.entities.Funcionario;
import com.projeto.entities.Projeto;
import com.projeto.services.ClientesService;
import com.projeto.services.DepartamentoService;
import com.projeto.services.EmpresaService;
import com.projeto.services.FornecedorService;
import com.projeto.services.FuncionarioService;
import com.projeto.services.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ApiExterna", description = "API REST EXTERNA")
@RestController
@RequestMapping("/apiExterna")
public class ApiExternaController {

	private final ClientesService clientesService;
	private final DepartamentoService departamentoService;
	private final EmpresaService empresaService;
	private final FornecedorService fornecedorService;
	private final FuncionarioService funcionarioService;
	private final ProjetoService projetoService;
	
	@Autowired
    public ApiExternaController(ClientesService clientesService, DepartamentoService departamentoService, EmpresaService empresaService, FornecedorService fornecedorService, FuncionarioService funcionarioService, ProjetoService projetoService) {
        this.clientesService = clientesService;
        this.departamentoService = departamentoService;
        this.empresaService = empresaService;
        this.fornecedorService = fornecedorService;
        this.funcionarioService = funcionarioService;
        this.projetoService = projetoService;
    }
	@GetMapping("/clientes")
    @Operation(summary = "Apresenta todos os Clientes")
    public ResponseEntity<List<Clientes>> getAllClientess() {
        List<Clientes> clientess = clientesService.getAllClientess();
        return ResponseEntity.ok(clientess);
	}
	@GetMapping("/departamentos")
    @Operation(summary = "Apresenta todos as Departamentos")
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        List<Departamento> departamentos = departamentoService.getAllDepartamentos();
        return ResponseEntity.ok(departamentos);
    }
	@GetMapping("/empresas")
    @Operation(summary = "Apresenta todos as Empresas")
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> empresas = empresaService.getAllEmpresas();
        return ResponseEntity.ok(empresas);
    }
	@GetMapping("/fornecedores")
    @Operation(summary = "Apresenta todos os Fornecedores")
    public ResponseEntity<List<Fornecedor>> getAllFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.getAllFornecedores();
        return ResponseEntity.ok(fornecedores);
    }
	@GetMapping("/funcionarios")
	@Operation(summary = "apresenta todos os funcionarios")
	public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
		List<Funcionario> funcionario = funcionarioService.getAllFuncionarios();
		return ResponseEntity.ok(funcionario);
	}
	@GetMapping("/projetos")
    @Operation(summary = "Apresenta todos os projetos")
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        List<Projeto> projetos = projetoService.getAllProjetos();
        return ResponseEntity.ok(projetos);
    }
}