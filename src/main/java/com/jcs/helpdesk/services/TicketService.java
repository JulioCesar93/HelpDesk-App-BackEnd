package com.jcs.helpdesk.services;

import com.jcs.helpdesk.domain.Cliente;
import com.jcs.helpdesk.domain.Tecnico;
import com.jcs.helpdesk.domain.Ticket;
import com.jcs.helpdesk.domain.dtos.TicketDTO;
import com.jcs.helpdesk.domain.enums.Prioridade;
import com.jcs.helpdesk.domain.enums.Status;
import com.jcs.helpdesk.repositories.TicketRepository;
import com.jcs.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Ticket findById(Integer id) {
        Optional<Ticket> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Ticket não encontrado! OS: " + id));
    }

    public List<Ticket> findAll() {
        return repository.findAll();
    }

    public Ticket create(@Valid TicketDTO objDTO) {
        return repository.save(newTicket(objDTO));
    }

    public Ticket update(Integer id, @Valid TicketDTO objDto) {
        objDto.setId(id);
        Ticket oldObj = findById(id);
        oldObj = newTicket(objDto);
        return repository.save(oldObj);
    }

    private Ticket newTicket(TicketDTO obj) {
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Ticket ticket = new Ticket();
        if(obj.getId() != null) {
            ticket.setId(obj.getId());
        }
        if(obj.getStatus().equals(2)) {
            ticket.setDataFechamento(LocalDate.now());
        }

        ticket.setTecnico(tecnico);
        ticket.setCliente(cliente);
        ticket.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        ticket.setStatus(Status.toEnum(obj.getStatus()));
        ticket.setTitulo(obj.getTitulo());
        ticket.setObservacoes(obj.getObservacoes());
        return ticket;
    }
}
