package com.projeto.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.entities.Projeto;
import com.projeto.repository.ProjetoRepository;

	@Service
	public class ProjetoService {
	    private final ProjetoRepository projetoRepository;
	    
	    @Autowired
	    public ProjetoService(ProjetoRepository projetoRepository) {
	        this.projetoRepository = projetoRepository;
	    }

	    public List<Projeto> getAllProjetos() {
	        return projetoRepository.findAll();
	    }

	    public Projeto getProjetoById(Long id) {
	        Optional<Projeto> projetos = projetoRepository.findById(id);
	        return projetos.orElse(null);
	    }

	    public Projeto salvarProjeto(Projeto projeto) {
	        return projetoRepository.save(projeto);
	    }

	    public Projeto updateProjeto(Long id, Projeto updatedProjeto) {
	        Optional<Projeto> existingProjeto = projetoRepository.findById(id);
	        if (existingProjeto.isPresent()) {
	            updatedProjeto.setId(id);
	            return projetoRepository.save(updatedProjeto);
	        }
	        return null;
	    }
	    public boolean deleteProjeto(Long id) {
	        Optional<Projeto> existingProjeto = projetoRepository.findById(id);
	        if (existingProjeto.isPresent()) {
	        	projetoRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
	}