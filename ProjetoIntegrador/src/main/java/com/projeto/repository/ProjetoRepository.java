package com.projeto.repository;

 import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Projeto;

	public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}