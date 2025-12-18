package com.crmconsulta.dto;

import com.crmconsulta.entidade.Medico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoCRM {

	private String nome;
	private String crm;

	public MedicoCRM(Medico crm) {
		this.nome = crm.getNome();
		this.crm = crm.getCrm();
		
	}

}
