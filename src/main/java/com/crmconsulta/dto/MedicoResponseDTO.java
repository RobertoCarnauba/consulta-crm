package com.crmconsulta.dto;

import com.crmconsulta.entidade.Medico;

public record MedicoResponseDTO(
		
		Long ig,
		String nome,
		String crm
		
		) {
	
	public MedicoResponseDTO(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getCrm());
	}

}
