package com.crmconsulta.dto;

import jakarta.validation.constraints.NotBlank;

public record MedicoCreateDTO(
		@NotBlank
		String nome,
		@NotBlank
		String crm,
		@NotBlank
		String email,
		@NotBlank
		String especialidade,
		String logradouro,
		String bairro,
		String cep,
		String complemento,
		String numero,
		String uf,
		String cidade,
		Boolean ativo,		
		
		String telefone
		) {}
