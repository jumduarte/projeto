package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}