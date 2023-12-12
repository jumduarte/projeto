package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Funcionario;


public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>{

}