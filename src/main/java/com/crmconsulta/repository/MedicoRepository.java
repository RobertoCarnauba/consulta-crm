package com.crmconsulta.repository;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmconsulta.entidade.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


}
