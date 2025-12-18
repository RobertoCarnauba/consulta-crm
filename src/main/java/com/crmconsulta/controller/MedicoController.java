package com.crmconsulta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crmconsulta.dto.MedicoResponseDTO;
import com.crmconsulta.service.MedicoService;

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

}
