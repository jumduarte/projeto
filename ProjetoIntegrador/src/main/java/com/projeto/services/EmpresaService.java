package com.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.entities.Empresa;
import com.projeto.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    
    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Long id) {
        Optional<Empresa> empresas = empresaRepository.findById(id);
        return empresas.orElse(null);
    }

    public Empresa salvarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa updateEmpresa(Long id, Empresa updatedEmpresa) {
        Optional<Empresa> existingEmpresa = empresaRepository.findById(id);
        if (existingEmpresa.isPresent()) {
            updatedEmpresa.setId(id);
            return empresaRepository.save(updatedEmpresa);
        }
        return null;
    }
    public boolean deleteEmpresa(Long id) {
        Optional<Empresa> existingEmpresa = empresaRepository.findById(id);
        if (existingEmpresa.isPresent()) {
        	empresaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}