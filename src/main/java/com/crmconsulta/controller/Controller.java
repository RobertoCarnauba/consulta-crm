package com.crmconsulta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crmconsulta.dto.MedicoCRM;
import com.crmconsulta.repository.MedicoRepository;

@RestController
@RequestMapping("/consulta_crm")
public class Controller {
	
	@Autowired
	private MedicoRepository repository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity consultaCrm (@PathVariable Long id){
		var crm = repository.getReferenceById(id);
		System.out.println(crm.getNome());
		return ResponseEntity.ok().body(new MedicoCRM(crm));
		
	}

}
