package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}