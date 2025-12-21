package com.crmconsulta.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crmconsulta.dto.MedicoCreateDTO;
import com.crmconsulta.dto.MedicoResponseDTO;
import com.crmconsulta.dto.MedicoUpdateDTO;
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
	
	public Page<MedicoResponseDTO> listar(org.springframework.data.domain.Pageable pageable) {
	    return repository.findAll(pageable)
	            .map(MedicoResponseDTO::new);
	}
	
	public MedicoResponseDTO atualizar(Long id, MedicoUpdateDTO dto) {
		
		Medico medico = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("--- Médico não LOCALIZADO! ---"));
		
		medico.setNome(dto.nome());
		medico.setEmail(dto.email());
		medico.setTelefone(dto.telefone());
		
		repository.save(medico);
		
		return new MedicoResponseDTO(medico);
	}
	
	public MedicoResponseDTO criar(MedicoCreateDTO dto) {
		
		Medico medico = new Medico();
		
		medico.setNome(dto.nome());
		medico.setCrm(dto.crm());
		medico.setEmail(dto.email());
		medico.setEspecialidade(dto.especialidade());
		medico.setLogradouro(dto.logradouro());
		medico.setBairro(dto.bairro());
		medico.setCep(dto.cep());
		medico.setComplemento(dto.complemento());
		medico.setNumero(dto.numero());
		medico.setUf(dto.uf());
		medico.setCidade(dto.cidade());
		medico.setAtivo(dto.ativo());
		medico.setTelefone(dto.telefone());
		
		repository.save(medico);
		
		return new MedicoResponseDTO(medico);
	}
	
	public void deletar(Long id) {
	    if (!repository.existsById(id)) {
	        throw new EntityNotFoundException("Médico não encontrado");
	    }
	    repository.deleteById(id);
	}


}
