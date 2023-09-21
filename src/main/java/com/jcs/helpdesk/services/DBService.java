package com.jcs.helpdesk.services;

import com.jcs.helpdesk.domain.Cliente;
import com.jcs.helpdesk.domain.Tecnico;
import com.jcs.helpdesk.domain.Ticket;
import com.jcs.helpdesk.domain.enums.Perfil;
import com.jcs.helpdesk.domain.enums.Prioridade;
import com.jcs.helpdesk.domain.enums.Status;
import com.jcs.helpdesk.repositories.ClienteRepository;
import com.jcs.helpdesk.repositories.TecnicoRepository;
import com.jcs.helpdesk.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Lemes Gustavo", "52584633035", "Lemesgus@mail.com", encoder.encode("123"));
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Amanda Fernandes", "45082546082", "amandafer261102@mail.com", encoder.encode("123"));

        Ticket sr1 = new Ticket(null, Prioridade.MEDIA, Status.ANDAMENTO, "SR-01", "Primeiro Ticket", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        ticketRepository.saveAll(Arrays.asList(sr1));
    }
}
