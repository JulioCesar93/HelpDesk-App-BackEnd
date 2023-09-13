package com.jcs.helpdesk.services;

import com.jcs.helpdesk.domain.Ticket;
import com.jcs.helpdesk.repositories.TicketRepository;
import com.jcs.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    public Ticket findById(Integer id) {
        Optional<Ticket> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Ticket não encontrado! OS: " + id));
    }
}
