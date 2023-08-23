package com.jcs.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jcs.helpdesk.domain.Ticket;

public interface TicketRepository extends JpaRepository <Ticket, Integer> {

}
