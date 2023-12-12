package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}