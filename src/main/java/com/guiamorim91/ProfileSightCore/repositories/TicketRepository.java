package com.guiamorim91.ProfileSightCore.repositories;

import com.guiamorim91.ProfileSightCore.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
