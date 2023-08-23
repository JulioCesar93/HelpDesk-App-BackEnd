package com.jcs.helpdesk.repositories;

import com.jcs.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository <Tecnico, Integer> {

}
