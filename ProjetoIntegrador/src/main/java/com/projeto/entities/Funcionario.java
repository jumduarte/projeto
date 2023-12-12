package com.projeto.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotNull
	@NotBlank
	private String nome;
		
	@NotNull
	@NotBlank
	private String cargo;
		
	@NotNull
	private double salario;
		
	@NotNull
	@NotBlank
	private String areaatuacao;
	
	@NotNull
	@NotBlank
	private String localtrabalho;
}