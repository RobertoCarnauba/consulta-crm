package com.crmconsulta.service;

import org.springframework.stereotype.Service;

import com.crmconsulta.dto.MedicoResponseDTO;
import com.crmconsulta.entidade.Medico;
import com.crmconsulta.repository.MedicoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MedicoService {
	
	private final MedicoRepository repository;
	
	public MedicoService(MedicoRepository repository) {
		this.repository = repository;
	}
	
	public MedicoResponseDTO buscarPorId(Long id) {
		Medico medico = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("--- Médico não LOCALIZADO! ---"));
		return new MedicoResponseDTO(medico);
	}

}
