package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}