package com.jcs.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa {

    private List<Ticket> tickets = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha, List<Ticket> tickets) {
        super(id, nome, cpf, email, senha);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
