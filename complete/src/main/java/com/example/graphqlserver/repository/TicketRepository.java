package com.example.graphqlserver.repository;

import com.example.graphqlserver.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository  extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findById (Long id);
}
