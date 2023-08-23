package com.jcs.helpdesk.repositories;

import com.jcs.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Integer> {

}
