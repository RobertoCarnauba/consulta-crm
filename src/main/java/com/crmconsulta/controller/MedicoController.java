package com.crmconsulta.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crmconsulta.dto.MedicoCreateDTO;
import com.crmconsulta.dto.MedicoResponseDTO;
import com.crmconsulta.dto.MedicoUpdateDTO;
import com.crmconsulta.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	private final MedicoService service;
	
	public MedicoController(MedicoService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicoResponseDTO> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MedicoResponseDTO> atualizar(
			@PathVariable Long id,
			@RequestBody  MedicoUpdateDTO dto){
				return ResponseEntity.ok(service.atualizar(id, dto));
		
	}
	
	@PostMapping
	public ResponseEntity<MedicoResponseDTO> criar(
			@RequestBody @Valid MedicoCreateDTO dto,
			UriComponentsBuilder uriBuilder){
		
		MedicoResponseDTO response = service.criar(dto);
		
		URI uri = uriBuilder
				.path("/medico/{id}")
				.buildAndExpand(response.ig())
				.toUri();
		
		return ResponseEntity.created(uri).body(response);
	}

}
