package com.guiamorim91.ProfileSightCore.services;

import com.guiamorim91.ProfileSightCore.entities.Ticket;
import com.guiamorim91.ProfileSightCore.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket create() {
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(new Date());
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
}
