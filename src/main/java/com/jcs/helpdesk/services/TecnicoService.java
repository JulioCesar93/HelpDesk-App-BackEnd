package com.jcs.helpdesk.services;

import com.jcs.helpdesk.domain.Tecnico;
import com.jcs.helpdesk.repositories.TecnicoRepository;
import com.jcs.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById (Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não foi encontrado! Id: " + id));
    }
}