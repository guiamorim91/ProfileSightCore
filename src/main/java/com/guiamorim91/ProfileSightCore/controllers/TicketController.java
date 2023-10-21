package com.guiamorim91.ProfileSightCore.controllers;

import com.guiamorim91.ProfileSightCore.entities.Ticket;
import com.guiamorim91.ProfileSightCore.services.TicketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Ticket", description = "Id de sessão para usuários anônimos, para salvar as respostas.")
@RestController
@RequestMapping("api/ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("")
    public ResponseEntity<Ticket> getNewTicket() {
        Ticket ticket = ticketService.create();
        return ResponseEntity.ok(ticket);
    }
}
